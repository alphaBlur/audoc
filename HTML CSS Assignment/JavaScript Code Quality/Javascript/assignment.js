// Analyzes the input of the box and compares it with regular expression to find whether the input is text or number and displays result accordingly
function analyzeInput(){
	var userInput=document.getElementById("input").value; // fetches input from the textbox
	var wordRegex=/^[a-zA-Z ]+$/; // Defines word in regular expression
	var numberRegex=/^-?\d+\.?\d*$/; // Defines number in regular expression
	if (userInput.match(wordRegex)) // checks if word
		displayWord(userInput);
	else if(userInput.match(numberRegex)) //checks if number
		analyzeNumber(userInput);
	else
		document.getElementById("result").innerHTML = "This is not right" ; // undesired input
}

//displays the word with info
function displayWord(word){
	document.getElementById("result").innerHTML = "The name entered is " + word;
}

//analyses the input and displays result accordingly
function analyzeNumber(number){
	if(number<0 || number>1000)
		document.getElementById("result").innerHTML = "It is not valid ( try from 0 to 1000 )" ;
	else if(number<50)
		document.getElementById("result").innerHTML = "The number is less than 50" ;
	else if(number>100)
		document.getElementById("result").innerHTML = "The number is greater than 100" ;
	else
		document.getElementById("result").innerHTML = "The number is between 50 and 100" ;
}

function checkBoxChanged(){
	var element = document.getElementById("checker");
	if(element.checked == true){
		document.getElementById("header").innerHTML = 'Click for number accepting mode';
		document.getElementById("numberAccepting").style.display="none";
		document.getElementById("nameAccepting").style.display="block";
	}
	else{
		document.getElementById("header").innerHTML = 'Click for name accepting mode';
		document.getElementById("numberAccepting").style.display="block";
		document.getElementById("nameAccepting").style.display="none";
	}

}
var rows=0;
function addToTable(){
	rows++; // keeps tracks of the rows in table

	var table = document.getElementById("list");
	var name = document.getElementById("name").value;
	var age = document.getElementById("age").value;
	
	//invalid input checker and keeps tracks of the errors
	var error='';
	if(! name.match(/^[a-zA-Z ]+$/)){
		error = "-Invalid name-";
	}
	if(age==""){
		error+="-Invalid Age-" ;
	}
	if(document.getElementById('male').checked == false && document.getElementById('female').checked == false){
		error+="-Please select gender-";
	}
	if(error != ''){
		document.getElementById("error").innerHTML=error;
		setTimeout(function(){ document.getElementById("error").innerHTML=""; }, 1000);
		rows--;
		return false;
	}
	
	//finds the selected gender
	if(document.getElementById('male').checked == true)
		gender = document.getElementById('male').value;
	else
		gender = document.getElementById('female').value;
	
	//Handle if the table is used for first time
	if(rows==1){
		var row = table.insertRow(0);
		
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		
		cell1.innerHTML = "SL.No.";
		cell2.innerHTML = "Name"
		cell3.innerHTML = "Gender";
		cell4.innerHTML = "Comments";
	}
	
	// The table formation happens here
	var row = table.insertRow(rows);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
    cell1.innerHTML = rows;
    cell2.innerHTML = name
	cell3.innerHTML = gender;
	if(gender == "Male")
		cell4.innerHTML = 'Name is Master ' + name;
	else
		cell4.innerHTML = 'Name is Miss ' + name;
	
}