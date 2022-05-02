<html>
<style>
.button {
  border: none;
  color: lightblue;
  padding: 16px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  transition-duration: 0.4s;
  cursor: pointer;
  align:center
  
}

.button1 {
  background-color: white;
  color: black;
  border: 2px solid #4CAF60;
    
}

.button1:hover {
  background-color: #4CAF60;
  color: powderblue;
}

.button2 {
  background-color: white;
  color: black;
  border: 2px solid #008CBA;
  
}

.button2:hover {
  background-color: #008CBC;
  color: yellow;
}
</style>
<body style="background-color:yellow;">
<h2 style="text-align:center;">Welcome to FIS Airlines</h2>
<form action="user-page.jsp" >
    <button class="button button1">User-Login </button>
</form><br>
<form action="admin-page.jsp" >
    <button class="button button1">Admin-Login</button>
</form>

<h3> </h3>
</body>
</html>
