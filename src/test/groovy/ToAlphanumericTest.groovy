import org.junit.*
import com.lesfurets.jenkins.unit.*
import static groovy.test.GroovyAssert.*

class ToAlphanumericTest extends BasePipelineTest {
	def toAlphanumeric

	@Before
	void setUp() {
		super.setUp()
		toAlphanumeric = loadScript("vars/toAlphanumeric.groovy")
	}

	@Test
	void testCall() {
		assertEquals "result:", "abc1", toAlphanumeric(text: "a_B-c.1")
	}
}