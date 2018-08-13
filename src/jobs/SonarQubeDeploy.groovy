package jobs

/**
 * Usage:
 *    new jobs.SonarQubeDeploy().call()
 *    new jobs.SonarQubeDeploy().call <key>: <value>[, ...]
 */
def call(Map opts = [:]) {
	try {
		stage("Database") {
			// ...
		}

		stage("Server") {
			// ...
		}
	} catch(Exception e) {
		echo "$e"
		// send to Slack
	}
}