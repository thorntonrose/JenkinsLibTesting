package jobs

import org.junit.*
import static groovy.test.GroovyAssert.*

class SonarQubeDeployTest extends BaseTest {
	def sonarQubeDeploy

	@Before
	void setUp() {
		super.setUp()
		sonarQubeDeploy = loadScript("src/jobs/SonarQubeDeploy.groovy")
	}

	@Test
	void testCall() {
		// ...
	}
}
