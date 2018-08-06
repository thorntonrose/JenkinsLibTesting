import org.junit.*
import com.lesfurets.jenkins.unit.*
import org.slf4j.*
import static groovy.test.GroovyAssert.*

class BaseTest extends BasePipelineTest {
	// private static final log = LoggerFactory.getLogger(BaseTest)

	@Before
	void setUp() {
		super.setUp()

		// helper.registerAllowedMethod("echo", [ String ]) { arg ->
		// 	log.debug "(echo) $arg"
		// }

		// load all steps from vars directory
		new File("vars").eachFile { file ->
			def name = file.name.replace(".groovy", "")

			// register step with no args, example: toAlphanumeric()
			helper.registerAllowedMethod(name, []) { ->
				loadScript(file.path)()
			}

			// register step with Map arg, example: toAlphanumeric(text: "a")
			helper.registerAllowedMethod(name, [ Map ]) { opts ->
				loadScript(file.path)(opts)
			}
		}
	}
}
