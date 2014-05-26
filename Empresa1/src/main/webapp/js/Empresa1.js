//Esto es un copypaste de un servicio REST que hice en clase de MTIS.
//A su vez es un copy paste de un servicio REST de mi proyecto de fin de grado.
//De momento dejo los nombrs tal y como estan pq funciona.
//Lamento el lio que pueda dar el nombrado.
Empresa1 = function Empresa1() {

	this.fireEmployeeReport = new FireEmployeeReport();
	
	this.businessId = "Empresa1";

	this.api = {}; // Data about de REST-API. Host, collection, url, etc
	this.employees = []; // Array of employees of the business

	this.init = function init() {
		
		this.fireEmployeeReport.init();

		_.bindAll(this, "getEmployees");
		_.bindAll(this, "onGetEmployeesResponse");
		
		_.bindAll(this, "getFireEmployeeReports");

		_.bindAll(this, "drawEmployees");

		_.bindAll(this, "fireEmployee");
		_.bindAll(this, "fireEmployeeAJAX");

		_.bindAll(this, "fireEmployeeRestXML");
		_.bindAll(this, "fireEmployeeAJAXXML");

		_.bindAll(this, "onfireEmployeeAJAXSuccess");
		
		_.bindAll(this, "onAjaxError");
		_.bindAll(this, "onAjaxSuccess");

		$("#getEmployeesButton").click(this.getEmployees);
		$("#getFireEmployeeReportsButton").click(this.getFireEmployeeReports);

		this.api.host = "api";
		this.api.url = function() {
			return this.host + "/" + this.collection + "/";
		};
	};

	this.getEmployees = function getEmployees() {

		this.api.collection = "employees";

		var resourceUrl = this.api.url();

		$.ajax({
			url : resourceUrl,
			type : "GET",
			dataType : 'json',
		}).done(this.onGetEmployeesResponse).fail(this.onAjaxError);
	};

	this.onGetEmployeesResponse = function onGetEmployeesResponse(data, status,
			xhr) {
		console.log(
				"Empresa1.OnGetEmployeesResponse(data %O, status %O, xhr %O)",
				data, status, xhr);

		this.employees = data;
		this.drawEmployees();
	};

	this.getFireEmployeeReports = function getFireEmployeeReports() {

		console.log("Empresa1.getFireEmployeeReports()");
		
		this.api.collection = "isOkAndFireEmployeeReports";

		var resourceUrl = this.api.url();

		$.ajax({
			url : resourceUrl,
			type : "GET",
			dataType : 'json',
		}).done(this.fireEmployeeReport.onGetCollectionResponse).fail(this.onAjaxError);
	};
	
	this.onAjaxError = function onAjaxError(xhr, status, error) {
		console
				.log(
						"Empresa1.onAjaxError(xhr %O, status %O, error %O) xhr.responseText %O",
						xhr, status, error, xhr.responseText);
	};

	this.onAjaxSuccess = function onAjaxSuccess(data, status, xhr) {
		console.log("Empresa1.onAjaxSuccess(data %O, status %O, xhr %O)", data,
				status, xhr);
	};

	this.drawEmployees = function drawEmployees() {

		var employees = this.employees;

		var employee;
		var employeeDNI;
		var employeeName;

		var tableBody = $("#employeeTableBody");

		var html = '<tr>No se han encontrado empleados</tr>';

		if (employees && employees.length > 0) {

			for (var i = 0; i < employees.length; i++) {

				employee = employees[i];
				employeeDNI = employee.dni.dni.id;
				employeeName = employee.dni.dni.completeName;

				html += '<tr><td>'
						+ employeeDNI
						+ '</td><td>'
						+ employeeName
						+ '</td><td>blablabla</td><td><button class="btn btn-danger" onclick="javascript:empresa1.fireEmployee('
						+ employeeDNI
						+ ')">REST-JSON</button><button class="btn btn-danger" onclick="javascript:empresa1.fireEmployeeRestXML('
						+ employeeDNI + ')">REST-XML</button><button class="btn btn-danger" onclick="javascript:empresa1.fireEmployeeJms('
						+ employeeDNI + ')">JMS-JSON</button></td></tr>';
			}
		}

		tableBody.html(html);
	};

	this.fireEmployee = function fireEmployee(DNInumber) {

		console.log("Empresa1.fireEmployee(DNInumber %O)", DNInumber);
		var data = {
			dniId : DNInumber,
			businessId : this.businessId
		};

		var dataJSON = JSON.stringify(data);

		this.fireEmployeeAJAX(dataJSON);
	};
	
	this.fireEmployeeJms = function fireEmployeeJms(DNInumber) {

		var data = {
			dniId : DNInumber,
			businessId : this.businessId
		};

		var dataJSON = JSON.stringify(data);

		this.fireEmployeeJmsAJAX(dataJSON);
	};

	this.fireEmployeeJmsAJAX = function fireEmployeeJmsAJAX(data) {
		$.ajax({
			url : 'api/fireEmployeeJMS',
			type : 'POST',
			dataType : 'json',
			contentType: 'application/json',
			data : data,
		}).done(this.onAjaxSuccess).fail(this.onAjaxError).always(function() {
			console.log("fireEmployeeJmsAJAX() - Complete");
		});
	};
	
	this.fireEmployeeAJAX = function fireEmployeeAJAX(data) {
		var proxyData = {
			url : 'http://localhost:8081/FireEmployee',
			data : data,
			contentType : 'application/json',
		};

		$.ajax({
			url : 'ProxyServlet',
			type : 'POST',
			dataType : 'json',
			data : proxyData,
		}).done(this.onfireEmployeeAJAXSuccess).fail(this.onAjaxError).always(function() {
			console.log("fireEmployeeAJAX() - Complete");
		});
	};
	
	this.onfireEmployeeAJAXSuccess = function onAjaxSuccess(data, status, xhr) {
		console.log("Empresa1.onfireEmployeeAJAXSuccess(data %O, status %O, xhr %O)", data,
				status, xhr);
		
		this.fireEmployeeReport.addToCollection(data);
	};

	this.fireEmployeeRestXML = function fireEmployeeRestXML(DNInumber) {
		
		console.log("Empresa1.fireEmployeeRestXML(DNInumber %O)", DNInumber);

		var data = '<DniIdAndBusinessId>' + '<dniId>'+ DNInumber +'</dniId>'
				+ '<businessId>'+ this.businessId +'</businessId>'
				+ '</DniIdAndBusinessId>';

		this.fireEmployeeAJAXXML(data);
	};

	this.fireEmployeeAJAXXML = function fireEmployeeAJAX(data) {
		var proxyData = {
			url : 'http://localhost:8081/FireEmployee',
			data : data,
			contentType : 'application/xml',
		};

		$.ajax({
			url : 'ProxyServlet',
			type : 'POST',
			dataType : 'json',
			data : proxyData,
		}).done(this.onfireEmployeeAJAXSuccess).fail(this.onAjaxError).always(function() {
			console.log("fireEmployeeAJAX() - Complete");
		});
	};
};