package jobs

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