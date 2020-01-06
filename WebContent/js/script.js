function validation() {
	var a = document.forms["myform"]["title"].value;
	if(a== "") {
		alert("Title is Required");
		return false;
	}
	if ((a.length < 2) || (a.length > 100)) {
        alert("Title should have 2 to 100 characters.");
        return false;
    }
	var b = document.forms["myform"]["gross"].value;
    if(b== "") {
        alert("Gross is required.");
		return false;
    }
	if(/[^0-9]/.test(b)) {
        alert("Gross has to be a number.");
		return false;
    }
	var c = document.forms["myform"]["txtDoB"].value;
	if(c== "") {
        alert("Date of Launch is required.");
		return false;
    }
	var d = document.forms["myform"]["genre"].value;
    if(d== "") {
        alert(" Select one Genre");
        return false;
    }
	}
