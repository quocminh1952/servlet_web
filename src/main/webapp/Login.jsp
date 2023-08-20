<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login/Register Form</title>
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.20/dist/sweetalert2.all.min.js"></script>
  <link rel="stylesheet" href="path_to_sweetalert2.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/11.7.20/sweetalert2.min.js" integrity="sha512-2AOp8GEFv1X43dZpYqOp34WD+skmM18yOrCxS/S1Mh6VShz7uxlPhKmA98fsPrE7MMMtZgjshiMHKmzWtZR5uA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
  <!-- Liên kết đến tệp CSS của Bootstrap -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <style>
    .logo-container {
      display: flex;
      justify-content: center;
      margin-bottom: 20px;
    }

    .logo {
      max-width: 150px;
      max-height: 150px;
    }
    .nav-item{
    width: 50%;
    }

    .loginMore button{
      background-color: white;
      color: black;
      padding: 5px;
    }

    .loginMore i{
      font-size: 20px;
     }

   	.red{
   		color:red;
   	}
   	
</style>
  
</head>
<body>
<%
	String fullName = request.getAttribute("fullName")+"";
	fullName = (fullName.equals("null"))?"":fullName;
	
	String address = request.getAttribute("address")+"";
	address = (address.equals("null"))?"":address;
	
	String numberPhone = request.getAttribute("numberPhone")+"";
	numberPhone = (numberPhone.equals("null"))?"":numberPhone;
	
	String userName = request.getAttribute("userName")+"";
	userName = (userName.equals("null"))?"":userName;
	
	String gender = request.getAttribute("gender")+"";
	gender = (userName.equals("null"))?"":gender;
	
	String email = request.getAttribute("email")+"";
	email = (email.equals("null"))?"":email;
	
	String password = request.getAttribute("password")+"";
	password = (password.equals("null"))?"":password;
	
	String confirmPassword = request.getAttribute("confirmPassword")+"";
	confirmPassword = (confirmPassword.equals("null"))?"":confirmPassword;
	
	String receiveEmail = request.getAttribute("receiveEmail")+"";
	receiveEmail = (receiveEmail.equals("null"))?"":receiveEmail;
	
	//err_Register
	String err_fullName = request.getAttribute("err_FullName")+"";
	err_fullName = (err_fullName.equals("null"))?"":err_fullName;
	
	String err_password = request.getAttribute("err_password")+"";
	err_password = (err_password.equals("null"))?"":err_password;
	
	String err_Email = request.getAttribute("err_Email")+"";
	err_Email = (err_Email.equals("null"))?"":err_Email;
	
	String err_userName = request.getAttribute("err_userName")+"";
	err_userName = (err_userName.equals("null"))?"":err_userName;
	
	//err_Login
	String err_Login = request.getAttribute("err_Login")+"";
	err_Login = (err_Login.equals("null"))?"":err_Login;
	
  %>
  
  <%
        // Xác định trạng thái của trang (đăng nhập hoặc đăng ký)
        String action = request.getParameter("action");
        if (action == null) {
            action = "login"; // Mặc định là trang đăng nhập
        }
  %>
  



  <div class="container mt-5">
    <div class="logo-container">
      <img class="logo" src="path_to_your_logo.png" alt="Logo của bạn">
    </div>
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs">
              <li class="nav-item">
                <a class="nav-link " id="login-tab" data-bs-toggle="tab" <%= action.equals("login") ? "show active" : "" %> href="#login-form">Login</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" id="register-tab" data-bs-toggle="tab" <%= action.equals("register") ? "show active" : "" %> href="#register-form">Register</a>
              </li>
            </ul>
          </div>
          <div class="card-body">
            <div class="tab-content">
              <div class="tab-pane fade show active" id="login-form">
                <form id="loginForm" action="login" method="post">
                  <div class="mb-2">
                    <label for="loginUsername" class="form-label">Username: <span class="red"><%=err_Login%></span></label>
                    <input type="text" class="form-control" id="loginUsername" name="loginUserName" required>
                  </div>
                  <div class="mb-2">
                    <label for="loginPassword" class="form-label">Password:<span class="red"><%=err_Login%></span></label>
                    <input type="password" class="form-control" id="loginPassword" name="loginPassword" required>
                  </div>
                  <button type="submit" class="btn btn-primary col-md-12 mb-2">Login</button>
                </form>
                <div class="mb-3">Another :</div>
                <div class="loginMore">
                  <div class="row">
                    <div class="col-md-6">
                      <button type="submit" class="form-group btn btn-primary col-md-12 mb-2">
                        <i class="fa-brands fa-facebook" style="color:  #2ba0e9;"></i>
                        Sign in with Facebook
                      </button>
                      <button type="submit" class="form-group btn btn-primary col-md-12 mb-2">
                        <i class="fa-brands fa-google" style="color: #f41a1a;"></i>
                        Sign in with Google
                      </button>
                    </div>
                    <div class="col-md-6">
                      <button type="submit" class="form-group btn btn-primary col-md-12 mb-2">
                        <i class="fa-brands fa-instagram" style="color: #ff2ed9;"></i>
                        Sign in with Instagram
                      </button>
                      <button type="submit" class="form-group btn btn-primary col-md-12 mb-2">
                        <i class="fa-brands fa-twitter" style="color: #2ba0e9;"></i>
                        Sign in with Twitter
                      </button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="tab-pane fade" id="register-form">
                <form id="registerForm" action="register" method="post">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-group mb-2">
                        <label for="fullName" class="form-label">Full Name:<span class="red"><%=err_fullName%></span></label>
                        <input name="fullName" type="text" class="form-control" id="fullName" value = "<%=fullName%>" required>
                      </div>
                      <div class="form-group mb-2">
                        <label for="gender" class="form-label" >Gender:</label>
                        <select name="gender" class="form-select" value="<%=gender%>" id="gender" required>
                          <option value="male">Male</option>
                          <option value="female">Female</option>
                          <option value="other">Other</option>
                        </select>
                      </div>
                      <div class="form-group mb-2">
                        <label for="fullName" class="form-label">Address:</label>
                        <input name="address" type="text" class="form-control" id="address" value = "<%=address%>" required>
                      </div>
                      <div class="form-group mb-2">
                        <label for="numberPhone" class="form-label">Number Phone:</label>
                        <input name="numberPhone" type="tel" class="form-control" pattern="[0-9]{3}[0-9]{3}[0-9]{4}" id="numberPhone" value = "<%=numberPhone%>" required>
                      </div>
                      
                    </div>
                    <div class="col-md-6">
                      
                      <div class="form-group mb-2">
                        <label for="fullName" class="form-label">User Name:</label>
                        <input name="userName" type="text" class="form-control" id="userName" value = "<%=userName%>" required>
                      </div>
                      <div class="form-group mb-2">
                        <label for="registerEmail" class="form-label">Email:<span class="red"><%=err_Email%></span></label>
                        <input name="email" type="email" class="form-control" id="registerEmail" value = "<%=email%>" required>
                      </div>
                      <div class="form-group mb-2">
                        <label for="registerPassword" class="form-label">Password:</label>
                        <input name="password" type="password" class="form-control" id="registerPassword" value = "<%=password%>" required>
                      </div>
                      <div class="form-group mb-2">
                        <label for="registerPassword" class="form-label">Confirm Password:<span class="red"><%=err_password%></span></label>
                        <input name="confirmPassword" type="password" class="form-control" id="registerPassword" value = "<%=confirmPassword%>" required>
                      	
                      </div>
                    </div>
                    <div class="form-check col-md-12">
                      <input name="receiveEmail" class="form-check-input" type="checkbox" id="receiveEmailNotifications">
                      <label class="form-check-label" for="receiveEmailNotifications">Receive Email Notifications</label>
                    </div>
                  </div>
                  <button type="submit" class="btn btn-primary col-md-12 mb-3" method="POST" onclick="checkPassword()">Register</button>
                  <div class="mb-3">Another :</div>
                  <div class="loginMore">
                    <div class="row">
                      <div class="col-md-6">
                        <button type="submit" class="form-group btn btn-primary col-md-12 mb-2">
                          <div class="icon_center">
                          <i class="fa-brands fa-facebook" style="color:  #2ba0e9;"></i>
                          </div>
                          Sign in with Facebook
                        </button>
                        <button type="submit" class="form-group btn btn-primary col-md-12 mb-2">
                          <div class="icon_center">
                          <i class="fa-brands fa-google" style="color: #f41a1a;"></i>
                          </div>
                          Sign in with Google
                        </button>
                      </div>
                      <div class="col-md-6">
                        <button type="submit" class="form-group btn btn-primary col-md-12 mb-2">
                          <div class="icon_center">
                          <i class="fa-brands fa-instagram" style="color: #ff2ed9;"></i>
                          </div>
                          Sign in with Instagram
                        </button>
                        <button type="submit" class="form-group btn btn-primary col-md-12 mb-2">
                          <div class="icon_center">
                          <i class="fa-brands fa-twitter" style="color: #2ba0e9;"></i>
                          </div>
                          Sign in with Twitter
                        </button>
                      </div>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>
  <script src="path_to_sweetalert2.min.js"></script>
  <script>
    const loginTab = document.getElementById('login-tab');
    const registerTab = document.getElementById('register-tab');
    const loginForm = document.getElementById('login-form');
    const registerForm = document.getElementById('register-form');

    loginTab.addEventListener('click', function() {
      loginTab.classList.add('active');
      registerTab.classList.remove('active');
      loginForm.classList.add('show', 'active');
      registerForm.classList.remove('show', 'active');
    });

    registerTab.addEventListener('click', function() {
      loginTab.classList.remove('active');
      registerTab.classList.add('active');
      loginForm.classList.remove('show', 'active');
      registerForm.classList.add('show', 'active');
    });

    window.onload = function () {
        const loginTab = document.getElementById('login-tab');
        const registerTab = document.getElementById('register-tab');
        const loginForm = document.getElementById('login-form');
        const registerForm = document.getElementById('register-form');

        const currentTab = localStorage.getItem('currentTab');

        if (currentTab === 'register') {
          loginTab.classList.remove('active');
          registerTab.classList.add('active');
          loginForm.classList.remove('show', 'active');
          registerForm.classList.add('show', 'active');
        }

        loginTab.addEventListener('click', function () {
          loginTab.classList.add('active');
          registerTab.classList.remove('active');
          loginForm.classList.add('show', 'active');
          registerForm.classList.remove('show', 'active');

          localStorage.setItem('currentTab', 'login');
        });

        registerTab.addEventListener('click', function () {
          loginTab.classList.remove('active');
          registerTab.classList.add('active');
          loginForm.classList.remove('show', 'active');
          registerForm.classList.add('show', 'active');

          localStorage.setItem('currentTab', 'register');
        });
      };

  
      // Hàm hiển thị thông báo thành công
      function showSuccessNotification() {
        Swal.fire({
          icon: 'success',
          title: 'Đăng ký thành công',
          text: 'Xin chúc mừng! Bạn đã đăng ký thành công.',
          confirmButtonText: 'OK',
        }).then((result) => {
          if (result.isConfirmed) {
            // Chuyển hướng người dùng trở lại trang đăng nhập
            localStorage.removeItem('currentTab');
         	// Thay 'login.jsp' bằng URL của trang đăng nhập.
            window.location.href = 'Login.jsp'; 
            
          }
        });
      }

      // Kiểm tra nếu có thông báo đăng ký thành công được gửi từ phía máy chủ
      const registrationSuccess = '<%= request.getAttribute("registrationSuccess") %>';
      if (registrationSuccess === 'true') {
        // Gọi hàm hiển thị thông báo
        showSuccessNotification();
      }

      // Kiểm tra tham số "action" và đặt tab đang hoạt động tương ứng
      const action = '<%= request.getParameter("action") %>';
      if (action === 'register') {
        loginTab.classList.remove('active');
        registerTab.classList.add('active');
        loginForm.classList.remove('show', 'active');
        registerForm.classList.add('show', 'active');
      } else {
        // Khôi phục tab đã lưu trong localStorage nếu không có tham số "action"
        const currentTab = localStorage.getItem('currentTab');
        if (currentTab === 'register') {
          loginTab.classList.remove('active');
          registerTab.classList.add('active');
          loginForm.classList.remove('show', 'active');
          registerForm.classList.add('show', 'active');
        }
      }

      
  </script>
  
</body>
</html>
