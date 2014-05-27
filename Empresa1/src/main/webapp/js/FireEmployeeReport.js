FireEmployeeReport = function FireEmployeeReport () {
	
	this.collection = [];
	
	this.init = function init() {
		
		_.bindAll(this, "onGetCollectionResponse");
	};
	
	this.onGetCollectionResponse = function onGetCollectionResponse(data, status,
			xhr) {
		console.log(
				"FireEmployeeReport.onGetCollectionResponse(data %O, status %O, xhr %O)",
				data, status, xhr);

		this.collection = data;
		this.drawCollection();
	};
	
	this.drawCollection = function drawCollection() {
		
		var collection = this.collection;

		var report;
		var reportDNI;
		var reportBusinessProcessState;
		var reportSocialSecurityProcessState;
		var reportIsFired;

		var tableBody = $("#fireEmployeeReportTableBody");

		var html = '<tr>No se han encontrado informes de despido</tr>';

		if (collection && collection.length > 0) {

			html = '';
			
			for (var i = 0; i < collection.length; i++) {

				report = collection[i];
				reportDNI = report.fireEmployeeReport.dniId;
				reportBusinessProcessState = report.fireEmployeeReport.businessProcessState;
				reportSocialSecurityProcessState = report.fireEmployeeReport.socialSecurityProcessState;
				reportIsFired = report.isCompletedWithoutErrors;

				html += '<tr><td>'
						+ reportDNI
						+ '</td><td>'
						+ reportBusinessProcessState
						+ '</td><td>'
						+ reportSocialSecurityProcessState
						+ '</td><td>'
						+ reportIsFired
						+ '</td></tr>';
			}
		}

		tableBody.html(html);
	};
	
	this.addToCollection = function addToCollection (report) {
		
		console.log("FireEmployeeReport.addToCollection(report %O)", report);
		
		empresa1.api.collection = "isOkAndFireEmployeeReports";
		var resourceUrl = empresa1.api.url();
		
		reportJSON = JSON.stringify(report);
		
		$.ajax({
			url : resourceUrl,
			type : "POST",
			contentType: "application/json",
			dataType : 'text',
			data: reportJSON,
		}).done(empresa1.getFireEmployeeReports).fail(empresa1.onAjaxError);
	};
};