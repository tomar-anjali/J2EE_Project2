<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>

	<style>
	
	*{
	    padding: 0;
	    margin: 0;
	    box-sizing: border-box;
	    font-family: cursive;
	    border: none;
	    outline: none;
	    text-decoration: none;
	    text-align: center;
	    
	}
	header{
	    text-align: center;
	    background-color: teal;
	    height: 10vh;
	    width: 100%;
	    padding: 0.5rem;
	    color: white;
	}
	
	.container{
	    height: 50vh;
	    width: 40%;
	    margin: 2rem auto;
	    background-color: teal;
	}
	.box{
	    height: 100%;
	    width: 100%;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    background-color: white;
	    border: 1px solid teal;
	    border-radius: 100% 2%;
	    animation: ani 30s infinite;
	}
	form{
	    width: 100%;
	}
	input,button{
	    display: block;
	    margin: 0.8rem auto;
	    padding: 0.3rem 0.5rem;
	    border-bottom: 1px black solid;
	    outline: none;
	    cursor: pointer;
	    background-color: transparent;
	}
	
	form input:focus{
	    border-bottom:1px solid;
	    outline: none;
	}
	
	input::placeholder{
	    outline: none;
	    border: none;
	    text-align: center;
	}
	
	@keyframes ani {
	    50%{
	        border-radius: 2% 100%;
	    }
	}
	a{
		
	}

 </style>

</head>
<body>
	<div class="container">
        <div class="box">
            <form action="signup" method="post">
            	<input type="text" name="id" placeholder="Enter ID" required="required">
            	<input type="text" name="name" placeholder="Enter Name" required="required">
                <input type="text" name="email" placeholder="Enter Email" required="required">
                <input type="password" name="password" placeholder="Enter password" required="required">
                <input type="text" name="sal" placeholder="Enter Salary" required="required">
                <button type="submit">Sign Up</button>
            </form>
            
            <p>Have account? <a href="index.jsp">
            <button style="border: none; margin-top:0;">Login</button></a></p>
            
        </div>
    </div>
</body>
</html>