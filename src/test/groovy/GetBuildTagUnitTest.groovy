import org.junit.*
import com.lesfurets.jenkins.unit.*
import static groovy.test.GroovyAssert.*

class GetBuildTagUnitTest extends BasePipelineTest {
	def getBuildTag

	@Before
	void setUp() {
		super.setUp()
		// load getBuildTag
		getBuildTag = loadScript("vars/getBuildTag.groovy")
	}

	@Test
	void testCall() {
		def hash = "9ee0fbdd081d0fa9e9d40dd904309be391e0fb2b"
		def timestamp = new Date().format("yyyyMMddHHmmss")
		def expected = "1\\.0\\.0\\-${timestamp[0..-3]}[0-5][0-9]\\-${hash[0..6]}"

		// create mock getCommitHash step
		helper.registerAllowedMethod("getCommitHash", []) { hash }

		// call getBuildTag and check result
		def result = getBuildTag(version: "1.0.0")
		assertTrue "result: not /$expected/", result as String ==~ expected
	}
}