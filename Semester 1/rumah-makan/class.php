<?php
 class rumahMakan {
    var $result;
    var $message;

    public function connectionDB(){
        $connect = mysqli_connect("localhost", "root", "", "kl_rumah-makan");
        if($connect)
            return $connect;
        else
            return "Connect Error :".mysqli_error(connectionDB());
    }

    public function login($username, $password, $table){
        $query = mysqli_query($this->connectionDB(), "SELECT * FROM $table WHERE username='$username'") or mysqli_error($this->connectionDB());
        if(mysqli_num_rows($query)==1){
            $this->result = mysqli_fetch_array($query);
            if(password_verify($password, $this->result['password'])){
                $_SESSION['id'] = $this->result['id'];
                $_SESSION['nama'] = $this->result['nama_lengkap'];
                $this->message = "Login Success!";
                header("Location: index.php?p=home"); 
            }else{
                $this->message = "<p>Maaf, Password anda salah</p>";
            }
        }else {
            $this->message = "<p>Maaf, Username atau Password anda salah</p>";
        }
    }

    public function checkLogin(){
        if(!isset($_SESSION['id'])&&empty($_SESSION['id'])){
            return false;
        }else{
            return true;
        }
    }

    public function logout($sesi){
         unset($sesi);
         session_destroy();
         header("Location: index.php?p=login");
     }

     public function getMessage(){
        return $this->message;
     }

     public function inputData(){
        
     }

     public function deleteData(){

     }

     public function updateData(){

     }
 }

?>