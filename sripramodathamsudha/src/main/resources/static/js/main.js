function printLabel() {
	//var prtContent = document.getElementById("printDiv");
	var prtContent = document.getElementById("label");
	var WinPrint = window.open('', 'Print Lables','left=0,top=0,width=800,height=900,toolbar=0,scrollbars=0,status=0');
	WinPrint.document.write('<html><head><title>Print Label</title>');
	WinPrint.document.write('<style>');
	WinPrint.document.write('#printDiv{width:2.625in;height:1in;color:blue;margin: 0mm;}');
	WinPrint.document.write('</style>');
	WinPrint.document.write('</head><body >');
	WinPrint.document.write('<p id="printDiv">');
	WinPrint.document.write(prtContent.innerText);
	WinPrint.document.write('</p>')
	WinPrint.document.write('</body></html>');
	WinPrint.document.close();
	WinPrint.focus();
	WinPrint.print();
	WinPrint.close();
}

function adjustToLabel() {
	//This function would help you to adjust the content of the form to the label.
}

function setupLabelView() {
	// This function helps to setup members details into label view of matrix	
}

function filterTableOverride() {
	// This function will provide an option to have filter by number of years by parsing the lable column from table.
	
}
