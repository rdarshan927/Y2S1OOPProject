package com.IT22097156.model;

public class VerificationResponseModel {
	private String successResponse;
	private String failResponse;
	private String deletesuccessResponse;
	private String deletefailResponse;
	public static VerificationResponseModel res = null;
	
	private VerificationResponseModel() {
		this.successResponse = "<html>\n" +
			    "<head>\n" +
			    "<title>Application Submission Status</title>\n" +
			    "<style>\n" +
			    ".container {\n" +
			    "  position: fixed;\n" +
			    "  top: 50%;\n" +
			    "  left: 50%;\n" +
			    "  transform: translate(-50%, -50%);\n" +
			    "  background-color: #4CAF50;\n" +
			    "  color: white;\n" +
			    "  padding: 20px;\n" +
			    "  border-radius: 10px;\n" +
			    "  text-align: center;\n" +
			    "}\n" +
			    "</style>\n" +
			    "</head>\n" +
			    "<body>\n" +
			    "<div class='container'>\n" +
			    "Application submitted successfully!<br>\n" +
			    "<div id='countdown'>Redirecting in <span id='countdownNumber'>3</span> seconds...</div>\n" +
			    "<script>\n" +
			    "var countdownNumber = 3;\n" +
			    "var countdown = document.getElementById('countdownNumber');\n" +
			    "var countdownTimer = setInterval(function() {\n" +
			    "    countdownNumber--;\n" +
			    "    countdown.textContent = countdownNumber;\n" +
			    "    if (countdownNumber <= 0) {\n" +
			    "        clearInterval(countdownTimer);\n" +
			    "        window.location.href = 'index.jsp';\n" +
			    "    }\n" +
			    "}, 1000);\n" +
			    "</script>\n" +
			    "</div>\n" +
			    "</body>\n" +
			    "</html>";


		this.failResponse = "<html>\n" +
			    "<head>\n" +
			    "<title>Application Submission Status</title>\n" +
			    "<style>\n" +
			    ".container {\n" +
			    "  position: fixed;\n" +
			    "  top: 50%;\n" +
			    "  left: 50%;\n" +
			    "  transform: translate(-50%, -50%);\n" +
			    "  background-color: #e74c3c;\n" + // Red background color for failure message
			    "  color: white;\n" +
			    "  padding: 20px;\n" +
			    "  border-radius: 10px;\n" +
			    "  text-align: center;\n" +
			    "}\n" +
			    "</style>\n" +
			    "</head>\n" +
			    "<body>\n" +
			    "<div class='container'>\n" +
			    "Application submission failed!<br>\n" +
			    "<div id='countdown'>Redirecting in <span id='countdownNumber'>3</span> seconds...</div>\n" +
			    "<script>\n" +
			    "var countdownNumber = 3;\n" +
			    "var countdown = document.getElementById('countdownNumber');\n" +
			    "var countdownTimer = setInterval(function() {\n" +
			    "    countdownNumber--;\n" +
			    "    countdown.textContent = countdownNumber;\n" +
			    "    if (countdownNumber <= 0) {\n" +
			    "        clearInterval(countdownTimer);\n" +
			    "        window.location.href = 'index.jsp';\n" +
			    "    }\n" +
			    "}, 1000);\n" +
			    "</script>\n" +
			    "</div>\n" +
			    "</body>\n" +
			    "</html>";

		this.deletesuccessResponse = "<html>\n" +
			    "<head>\n" +
			    "<title>Application Deletion Status</title>\n" +
			    "<style>\n" +
			    ".container {\n" +
			    "  position: fixed;\n" +
			    "  top: 50%;\n" +
			    "  left: 50%;\n" +
			    "  transform: translate(-50%, -50%);\n" +
			    "  background-color: #3498db;\n" + // Blue background color for deletion message
			    "  color: white;\n" +
			    "  padding: 20px;\n" +
			    "  border-radius: 10px;\n" +
			    "  text-align: center;\n" +
			    "}\n" +
			    "</style>\n" +
			    "</head>\n" +
			    "<body>\n" +
			    "<div class='container'>\n" +
			    "Application deleted successfully!<br>\n" +
			    "<div id='countdown'>Redirecting in <span id='countdownNumber'>3</span> seconds...</div>\n" +
			    "<script>\n" +
			    "var countdownNumber = 3;\n" +
			    "var countdown = document.getElementById('countdownNumber');\n" +
			    "var countdownTimer = setInterval(function() {\n" +
			    "    countdownNumber--;\n" +
			    "    countdown.textContent = countdownNumber;\n" +
			    "    if (countdownNumber <= 0) {\n" +
			    "        clearInterval(countdownTimer);\n" +
			    "        window.location.href = 'index.jsp';\n" +
			    "    }\n" +
			    "}, 1000);\n" +
			    "</script>\n" +
			    "</div>\n" +
			    "</body>\n" +
			    "</html>";

		this.deletefailResponse = "<html>\n" +
			    "<head>\n" +
			    "<title>Deletion Failure Status</title>\n" +
			    "<style>\n" +
			    ".container {\n" +
			    "  position: fixed;\n" +
			    "  top: 50%;\n" +
			    "  left: 50%;\n" +
			    "  transform: translate(-50%, -50%);\n" +
			    "  background-color: #e74c3c;\n" + // Red background color for deletion failure message
			    "  color: white;\n" +
			    "  padding: 20px;\n" +
			    "  border-radius: 10px;\n" +
			    "  text-align: center;\n" +
			    "}\n" +
			    "</style>\n" +
			    "</head>\n" +
			    "<body>\n" +
			    "<div class='container'>\n" +
			    "Deletion failed!<br>\n" +
			    "<div id='countdown'>Redirecting in <span id='countdownNumber'>3</span> seconds...</div>\n" +
			    "<script>\n" +
			    "var countdownNumber = 3;\n" +
			    "var countdown = document.getElementById('countdownNumber');\n" +
			    "var countdownTimer = setInterval(function() {\n" +
			    "    countdownNumber--;\n" +
			    "    countdown.textContent = countdownNumber;\n" +
			    "    if (countdownNumber <= 0) {\n" +
			    "        clearInterval(countdownTimer);\n" +
			    "        window.location.href = 'index.jsp';\n" +
			    "    }\n" +
			    "}, 1000);\n" +
			    "</script>\n" +
			    "</div>\n" +
			    "</body>\n" +
			    "</html>";

	}
	
	public static VerificationResponseModel getInstance() {
		if(res == null) {
			res = new VerificationResponseModel();
		}
		return res;
	}

	public String getSuccessResponse() {
		return this.successResponse;
	}

	public String getFailResponse() {
		return this.failResponse;
	}

	public String getDeletesuccessResponse() {
		return this.deletesuccessResponse;
	}

	public String getDeletefailResponse() {
		return this.deletefailResponse;
	}

}
