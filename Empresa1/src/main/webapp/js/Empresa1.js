//Esto es un copypaste de un servicio REST que hice en clase de MTIS.
//A su vez es un copy paste de un servicio REST de mi proyecto de fin de grado.
//De momento dejo los nombrs tal y como estan pq funciona.
//Lamento el lio que pueda dar el nombrado.
Empresa1 = function Empresa1() {

	this.businessId = "Empresa1";

	this.api = {}; // Data about de REST-API. Host, collection, url, etc
	this.employees = []; // Array of employees of the business

	this.init = function init() {

		_.bindAll(this, "getEmployees");
		_.bindAll(this, "onGetEmployeesResponse");

		_.bindAll(this, "drawEmployees");

		_.bindAll(this, "fireEmployee");
		_.bindAll(this, "fireEmployeeAJAX");

		_.bindAll(this, "onAjaxError");
		_.bindAll(this, "onAjaxSuccess");

		$("#getEmployeesButton").click(this.getEmployees);

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

	this.onAjaxError = function onAjaxError(xhr, status, error) {
		console.log("Empresa1.onAjaxError(xhr %O, status %O, error %O) xhr.responseText %O", xhr,
				status, error, xhr.responseText);
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
						+ employeeDNI + ')">Despedir</button><button class="btn btn-danger" onclick="javascript:empresa1.fireEmployeeJms('
						+ employeeDNI + ')">DespedirJMS</button></td></tr>';
			}
		}

		tableBody.html(html);
	};

	this.fireEmployee = function fireEmployee(DNInumber) {

		var data = {
			dniNumber : DNInumber,
			businessId : this.businessId
		};

		var dataJSON = JSON.stringify(data);

		this.fireEmployeeAJAX(dataJSON);
	};
	
	this.fireEmployeeJms = function fireEmployeeJms(DNInumber) {

		var data = {
			dniNumber : DNInumber,
			businessId : this.businessId
		};

		var dataJSON = JSON.stringify(data);

		this.fireEmployeeJmsAJAX(dataJSON);
	};

	this.fireEmployeeAJAX = function fireEmployeeAJAX(data) {
		$.ajax({
			url : 'ProxyServlet',
			type : 'POST',
			dataType : 'json',
			data : {
				url : 'http://localhost:8081/FireEmployee',
				data : data
			},
		}).done(this.onAjaxSuccess).fail(this.onAjaxError).always(function() {
			console.log("fireEmployeeAJAX() - Complete");
		});
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

};