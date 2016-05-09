import groovyx.net.http.RESTClient
import spock.lang.Specification

class DeleteProject extends Specification {

	RESTClient restClient = new RESTClient("https://todo.ly/")
	
	def setup() {
		restClient.setHeaders(
			"Authorization": "c29tYnJlcm9kZXBhamFAZ21haWwuY29tOk1hY3Jvc3My")
	}
	
	def "Delete a project"() {

		given: 'given a projectId'
		def projectId = 34653560
		
		when: 'request to delete project'
		def response = restClient.delete(path:"api/projects/${projectId}.json")

		then:
		response.status == 200
		response.data.Deleted == true
	}
}

