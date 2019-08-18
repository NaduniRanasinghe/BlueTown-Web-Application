<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Calculate Payments Form</title>


 <script type="text/javascript">
            function add_number(){
            var first_number = parseInt(document.getElementsById("Text1").value);
            var second_number = parseInt(document.getElementsById("Text2").value);
            var result = first_number + second_number;
            document.getElementById("txtresult").innerHTML = result;    
            }
        </script>



    <style>
      .content { position: relative; background: #2874A6;  height: 800px; border: 1px solid #6666ff;}
      .content div { position: relative; width: 45%; padding: 10px; }
      .//blue { right: 170px; bottom: 0; background: #1c87c9; }
      .green { top: 60px;height: 700px; left: 410px; width: 500px; background: #FDFEFE; }
    </style>
  </head>
  <body>
    <div class="content">
      

      <div class="green">

        
<h3> calculate monthly payment</h3>

<div align="left">
<div id="calclpayment">
    <div>
        <div>
           
        </div>
            Enter First Number : <br>
            <input type="text" id="Text1" name="TextBox1">
            <br>
            Enter Second Number : <br>
            <input type="text" id="Text2" name="TextBox2">
            <br>
            Result : <br>
            <input type="text" id="txtresult" name="TextBox3">
            <br>
         <input type="button" name="clickbtn" value="Display Result" onclick="add_number()">

       

  
          <br />
          <br />
       
    </div>

      </div>
    </div>
  </body>
</html>