<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Index</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <link rel="stylesheet" href="./assets/style.css">
    <!-- CDN-ICON --->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!--BOOTSTRAP-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
	<script>
       
  	</script>
<style>
body {
    margin: 0;
    font-family: Arial, sans-serif;
}

.welcome-notification {
    position: fixed;
    top: 0;
    width: 100%;
    background-color: #3498db;
    color: white;
    padding: 10px;
    display: none;
    text-align: center;
    z-index:100;
    animation: slideUp 0.5s ease-in-out 3s forwards;
}

@keyframes slideUp {
    to {
        top: -50%;
    }
}
    </style>
</head>
<body>
 <%-- Hiển thị thông báo chào mừng nếu có --%>
 
<div class="welcome-notification">
        <p>Hi <%=request.getAttribute("user_Welcome")%> Welcome to our website!</p>
</div>

<div class="main">
<!-- HEADER -->
    <!-- Navigation-->
    <div class="header-nav">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
          <a class="Logo_header navbar-brand" href="">
            <img class="logo" src ="./assets/img/Logo.png"/>
          </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Dropdown
                </a>
                <ul class="dropdown-menu">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">submenu_1</a></li>
                  <li><a class="dropdown-item" href="#">submenu_2</a></li>
                  <li><a class="dropdown-item" href="#">submenu_2</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled">Disabled</a>
              </li>
            </ul>
            <form class="d-flex" role="search">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
          </div>
          <div class="nav-user" onclick="showUser()">
            <i class="fa-solid fa-user" onclick="showUser()"></i>
          </div>
        </div>
      </nav>
    </div>
    <!--Slide-->
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
          </div>
        <div class="carousel-inner">
          <div class="carousel-item active" data-bs-interval="2000">
            <img src="./assets/img/Slide_01.png" class="d-block w-100 h-100 slide-size" alt="...">
          </div>
          <div class="carousel-item" data-bs-interval="2000">
            <div class="video-container">
                <video src="./assets/img/slider_clip01.mp4" class="w-100 h-100  slide-size" autoplay loop muted poster="path/to/poster.jpg"></video>
              </div>
          </div>
          <div class="carousel-item" data-bs-interval="2000" >
            <div class="video-container">
                <video src="./assets/img/slider_clip02.mp4" class="w-100 h-100 slide-size" autoplay loop muted poster="path/to/poster.jpg"></video>
              </div>
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
<!--Content-->
      <div class="content">
          <div class="content-card">

                <div class="card mb-3" style="max-width: 540px;">
                  <div class="row g-0">
                    <div class="col-md-4">
                      <img src="./assets/img/content01.png" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                      <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
                      </div>
                    </div>
                  </div>
                </div>
              
                <div class="card mb-3" style="max-width: 540px;">
                  <div class="row g-0">
                    <div class="col-md-4">
                      <img src="./assets/img/content02.png" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                      <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="card mb-3" style="max-width: 540px;">
                  <div class="row g-0">
                    <div class="col-md-4">
                      <img src="./assets/img/content03.png" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                      <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
                      </div>
                    </div>
                  </div>
                </div>

                <div class="card mb-3" style="max-width: 540px;">
                  <div class="row g-0">
                    <div class="col-md-4">
                      <img src="./assets/img/content04.png" class="img-fluid rounded-start" alt="...">
                    </div>
                    <div class="col-md-8">
                      <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
                        <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
        </div>

        <div class="card-product">
          <div class="card">
            <img src="./assets/img/product_1.png" class="card-img-top" alt="...">
          
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">BUY NOW</a>
            </div>
          </div>
          
          <div class="card">
            <img src="./assets/img/product_2.png" class="card-img-top" alt="...">
          
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">BUY NOW</a>
            </div>
          </div>

          <div class="card">
            <img src="./assets/img/product_3.png" class="card-img-top" alt="...">
          
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">BUY NOW</a>
            </div>
          </div>

          <div class="card">
            <img src="./assets/img/product_4.png" class="card-img-top" alt="...">
          
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">BUY NOW</a>
            </div>
          </div>

          <div class="card">
            <img src="./assets/img/product_5.png" class="card-img-top" alt="...">
          
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">BUY NOW</a>
            </div>
          </div>

          <div class="card">
            <img src="./assets/img/product_6.png" class="card-img-top" alt="...">
          
            <div class="card-body">
              <h5 class="card-title">Card title</h5>
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">BUY NOW</a>
            </div>
          </div>
        </div>

  <!--Footer-->
  <div>
      <div class=""></div>
      <div></div>
  </div>
</div>

<div id="showMe" class="model-user-controller" style="display: none;">
  <div class="model-container">
    <i class="fa-solid fa-x" onclick="hiddenUser()"></i>
      <div class="title-container">
            <span>USER</span>
            <i class="fa-solid fa-user"></i> 
      </div>
      <div class="cart-container">
          <i class="fa-solid fa-cart-shopping"></i>
          <span>Check your card</span>
      </div>
      <div class="information-container">
        <i class="fa-solid fa-circle-info"></i>
        <span>Setup Your infomaion</span>
      </div>
      <div class="logout-container">
        <button>Log-Out</button>
        <i class="fa-solid fa-right-from-bracket"></i>
      </div>
  </div>
</div>

<script>
  function showUser() {
    document.getElementById('showMe').style.display = 'block';
  }

  function hiddenUser(){
    document.getElementById('showMe').style.display= 'none';
  }

  document.addEventListener("DOMContentLoaded", function () {
	    const welcomeNotification = document.querySelector(".welcome-notification");
	    const closeBtn = document.getElementById("close-btn");

	    // Hiển thị thông báo khi tải trang xong
	    
	    welcomeNotification.style.display = <%=request.getAttribute("welcome_Notification")%>;

	    // Bắt sự kiện click để ẩn thông báo
	    closeBtn.addEventListener("click", function () {
	        welcomeNotification.style.display = "none";
	    });
	});

  document.addEventListener("DOMContentLoaded", function () {
	    const welcomeNotification = document.querySelector(".welcome-notification");

	    setTimeout(function() {
	        welcomeNotification.classList.add("slide-up");
	    }, 3000);
	});
</script>
</body>
</html>