<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="savereg" method="post">
	Name: <input type="text" name="studentName" value="${studentNameValue}" />
		<span style="color:red"> ${studentNameError}</span>
	<br><br>
	Playing Type:
	
	Batsman<input type="radio" name="playerType" value="Batsman" ${ studentPlayerValue.equals("Batsman")?"checked":""}  />
	Bowler<input type="radio" name="playerType" value="Bowler"  ${ studentPlayerValue.equals("Bowler")?"checked":""}/>
	AllRounder<input type="radio" name="playerType" value="allRounder" ${studentPlayerValue.equals("allRounder")?"checked":""}/>
		<span style="color:red"> ${playerTypeError }</span>
	<br><br>
	Food Preference:
		<select name="foodPreference">
			<option  name="foodPreference" value="-1">---Select Your Food Preference---</option>
			<option  name="foodPreference"  ${studentFoodValue.equals("Regular")?"selected":""} value="Regular">Regular</option>
			<option  name="foodPreference" ${studentFoodValue.equals("Jain")?"selected":""} value="Jain">Jain</option>
		</select>
		<span style="color:red"> ${foodPreferenceError}</span>
		<br><br>
	Drink: 
	RB:<input type="checkbox" name="drink" ${studentDrinkValue.contains("rd")?"checked":""} value="rd"/>
	MD:<input type="checkbox" name="drink" ${studentDrinkValue.contains("md")?"checked":""} value="md"/>
	Th:<input type="checkbox" name="drink"  ${studentDrinkValue.contains("th")?"checked":""} value="th"/>
	Co:<input type="checkbox" name="drink"  ${studentDrinkValue.contains("co")?"checked":""} value="co"/>
	Lj:<input type="checkbox" name="drink" ${studentDrinkValue.contains("lj")?"checked":""} value="lj"/>
	<span style="color:red"> ${drinkError}</span>
	<br><br>
	<input type="submit" value="Submit"/>
</form>
</body>
</html>