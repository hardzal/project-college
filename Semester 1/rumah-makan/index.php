<?php
ob_start();
session_start();
require_once "class.php";
$rm = new rumahMakan;
$connect = $rm->connectionDB();
?>
<!DOCTYPE html>
<html>
<head>
 <title>Home | Rumah Makan Salero Minang</title>
 <meta charset="UTF-8"/>
 <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <!--- Styling -->
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link href="" type="images/x-icon" rel="icon"/>
</head>
<body>
    <div id="container"> 
        <?php
            require_once "header.php";
            require "navigasi.php";
        ?>
        <section>
            <div class="content">
                <?php 
                $options = isset($_GET['p']) ? $_GET['p'] : "";
                if($options ==""){
                    $options = "home";
                }
                switch($options){
                    case "home":
                        if($rm->checkLogin())
                            require_once "content.php";
                        else   
                            header("Location: index.php?p=login");
                    break;
                    case "login":
                    ?>
                        <div class="forms">
                            <?php
                                if(isset($_POST['submit'])&&!empty($_POST['submit'])){
                                    $username = filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING);
                                    $password = filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING);
                                    $opsi     = filter_input(INPUT_POST, 'log_as');
                                    if($opsi=="member"){
                                        $login = $rm->login($username, $password, "data_member");          
                                    } else if($opsi =="admin"){    
                                        $login = $rm->login($username, $password, "data_admin");
                                    } 
                                }
                            ?>
                            <h3>Form Login</h3>
                            <?php echo $rm->getMessage();?>
                            <form method="post" action="">
                                <ul>
                                    <li>Username</li>
                                    <li><input type="text" name="username" placeholder="username..."/></li>
                                </ul>
                                <ul>
                                    <li>Password</li>
                                    <li><input type="password" name="password"/></li>
                                </ul>
                                <ul>
                                    <li>Login As</li>
                                    <li><select name="log_as">
                                            <option value="admin">Admin</option>
                                            <option value="member">Member</option>
                                        </select>
                                    </li>
                                </ul>
                                <ul>
                                    <li><input type="submit" name="submit" value="Login"/></li>
                                </ul>   
                            </form><br/>
                            <p>New Member? Register <a href="index.php?p=register" style="color: #C0392B">here</a></p>
                        </div>
                    <?php
                        break;
                    case "register":
                    ?>
                        <div class="forms" style="float: left;">
                        <h3>Form Register</h3>
                        <?php
                            if(isset($_POST['submit']) && !empty($_POST['submit'])){
                                $username   = filter_input(INPUT_POST, 'username', FILTER_SANITIZE_STRING);
                                $password   = password_hash($_POST['password'], PASSWORD_DEFAULT);
                                $email      = filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL);
                                $no_hp      = $_POST['hp'];
                                $full_name  = filter_input(INPUT_POST, $_POST['nama_lengkap']);
                                $ttl        = $_POST['ttl'];
                                $domisili   = $_POST['domisili'];
                                $kode_pos   = $_POST['kode_pos'];
                                $alamat     = $_POST['alamat'];
                                $q = mysqli_query($rm->connectionDB(),"INSERT INTO data_member VALUES('', '$username', '$password', '$full_name', '$ttl', '$domisili', '$alamat', '$kode_pos', '$hp', '$email')");
                                if($q) echo "<p>Berhasil Mendaftar!</p>";
                                else echo mysqli_error($rm->connectionDB());
                            }
                        ?>
                            <form method="post" action="">
                                <ul>
                                    <li>Username</li>
                                    <li><input type="text" name="username" maxlength="100" placeholder="username..." required/></li>
                                </ul>
                                <ul>
                                    <li>Password</li>
                                    <li><input type="password" name="password" maxlength="32" required/></li>
                                </ul>
                                <ul>
                                    <li>Email</li>
                                    <li><input type="email" name="email" required/></li>
                                </ul>
                                <ul>
                                    <li>No HP</li>
                                    <li><input type="text" name="hp" minlength="12" maxlength="12" required/></li>
                                </ul>
                                <ul>
                                    <li>Full Name</li>
                                    <li><input type="text" name="nama_lengkap" required/></li>
                                </ul>
                                <ul>
                                    <li>Tanggal Lahir</li>
                                    <li><input type="date" name="ttl" required/></li>
                                </ul>
                                <ul>
                                    <li>Domisli</li>
                                    <li><input type="text" name="domisili" required/></li>
                                </ul>
                                <ul>
                                    <li>Kode Pos</li>
                                    <li><input type="text" name="kode_pos" required/></li>
                                </ul>
                                <ul>
                                    <li>Alamat</li>
                                    <li><textarea name="alamat" required></textarea></li>
                                </ul>
                                <ul>
                                    <li><input type="submit" name="submit" value="Register"/></li>
                                </ul>   
                            </form> 
                            <p>Already Have Account? Login <a href="index.php?p=login" style="color: #C0392B">here</a></p>
                        </div>
                    <?php
                        break;
                    case "logout":
                      $rm->logout($_SESSION['id']);
                        break;
                    default:
                        header("Location: index.php?p=home");    
                }
                ?>
            </div>
        </section>
        <footer>
            <div class="footer">
               <?php require_once "footer.php";?>
            </div>
        </footer>
    </div>

</body>
</html>