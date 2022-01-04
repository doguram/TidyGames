<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
        .outer2{
            width: 1500px;
            height: 350px;
            margin: auto;
        }
  
        .mainImg{
            background: #587570;  
            width: 1500px;
            height: 330px;
            margin-top:60px;
        }
        .mainImg>span{
            width:30px;
        }
        span>a{
            width:40px;
            height:250px;
        }

        #carouselExampleIndicators{
            width: 100%;
            height: 100%;
        }

        .slideImg{
            display: inline-block;
            width:210px;
            height:300px;
            margin:5px;
            border: 1px solid black;
        }
</style>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        

</head>
<body   style="background-color: #0e332c;">

   <div class="outer2" align="center">

        <div class="mainImg">
            
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1" style="width:50px; background: rgb(47, 70, 50);"></button>
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2" style="width:50px;background: rgb(47, 70, 50);"></button>
                  <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3" style="width:50px;background: rgb(47, 70, 50);;"></button>
                </div>
                <div class="carousel-inner" >
                  <div class="carousel-item active">
                    <div class="slideImg" id="img1">
                        <a href="">
                          <img src="/resources/image/unnamed.jpg" class="d-block w-100">
                        </a>
                        
                    </div>
                    <div class="slideImg" id="img2">
                      <a href="">
                        <img src="" class="d-block w-100" alt="">
                      </a>
                       
                    </div>
                    <div class="slideImg" id="img3">
                      <a href="">
                        <img src="" class="d-block w-100" alt="">
                      </a>
                        
                    </div>
                    <div class="slideImg" id="img4">
                      <a href="">
                        <img src="" class="d-block w-100" alt="">
                      </a>
                        
                    </div>
                    <div class="slideImg" id="img5">
                      <a href="">
                        <img src="" class="d-block w-100" alt="">
                      </a>
                    </div>
                    

                  </div>
                  <div class="carousel-item">
                    <img src="" class="d-block w-100" alt="">
                  </div>
                  <div class="carousel-item">
                    <img src="" class="d-block w-100" alt="">
                  </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev" style="width: 45px;background: rgb(47, 70, 50);">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Prev</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next" style="width: 45px;background: rgb(47, 70, 50);">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="visually-hidden">Next</span>
                </button>
              </div>
            
        </div>
   </div>

