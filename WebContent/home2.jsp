  <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
               <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="main.css">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 
    </head>
    <body>
<div class="w3-top">
  <div class="w3-bar" id="myNavbar">
    <a class="w3-bar-item w3-button w3-hover-black w3-hide-medium w3-hide-large w3-right" href="javascript:void(0);" onclick="toggleFunction()" title="Toggle Navigation Menu">
      <i class="fa fa-bars"></i>
    </a>
    <a href="index.jsp" class="w3-bar-item w3-button">HOME</a>
     </div>

 <br>
</div>
      <form action="passwordchange" method="post">
      
        <h1>CHANGE PASSWORD</h1>
        
        <fieldset>
          <legend><span class="number">1</span> Your basic info</legend>
          <label for="username">Username:</label>
          <input type="text" id="username" name="username">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="password">
           <label for="password">New Password:</label>
          <input type="password" id="password2" name="password2">
          
          <label for="password2">Re-enter password:</label>
          <input type="password" id="password3" name="password3">
          
</fieldset>
        <button type="submit">CHANGE PASSWORD</button>
      </form>
      
      
    </body>
</html>