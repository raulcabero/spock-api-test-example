import groovyx.net.http.RESTClient
import spock.lang.Specification

class GetProject extends Specification {

	RESTClient restClient = new RESTClient("https://todo.ly/")
	
	def setup() {
		restClient.setHeaders(
			"Authorization": "c29tYnJlcm9kZXBhamFAZ21haWwuY29tOk1hY3Jvc3My")
		// you also can try this authentication:
		// restClient.auth.basic "myuser", "mypass"
	}
	
	def "Get a project"() {

		given: 'given a projectId'
		def projectId = 3465350
		
		when: 'request for project id'
		def response = restClient.get(path:"api/projects/${projectId}.json")

		then:
		response.status == 200
		response.data.Content == "myProject0"
		response.data.Icon == 4
		response.data.Deleted == false
		
	}
}

