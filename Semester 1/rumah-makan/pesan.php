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
 <title>Rumah Makan Salero Minang</title>
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
        <?php if($rm->checkLogin()){ ?>            
            <div class="content">
                <?php 
                $options = isset($_GET['menu']) ? $_GET['menu'] : "";
                $id_katalog = isset($_GET['id']) ? $_GET['id'] : "";
                if(!empty($options)&&!empty($id_katalog)){ 
                     $query = mysqli_query($connect,"SELECT * FROM katalog WHERE menu='$options' AND id_katalog='$id_katalog'") or die(mysqli_error($connect));
                     
                     $q_m = mysqli_fetch_array($query);
                }else{
                    header("Location: index.php");
                }
                switch($options){
                    case "Makanan":
                        if(!empty($id_katalog)){
                ?>
                        <div class="orderp">
                            <h3>Form Orders</h3>
                            <div class="prev-orderp"><img src="img/<?php echo $q_m['gambar'];?>" alt="<?php echo $q_m['nama'];?>" title="<?php echo $q_m['nama'];?>"/></div>
                            <div class="forms orderan">
                            <?php
                                if(!empty($_POST['submit'])&&isset($_POST['submit'])){
                                    $menu       = filter_input(INPUT_POST, 'menu');
                                    $price      = filter_input(INPUT_POST, 'harga');
                                    $id_pemesan = $_SESSION['id'];
                                    $pemesan    = filter_input(INPUT_POST, 'pemesan');
                                    $tambahan   = filter_input(INPUT_POST, 'tambahan');
                                    $alamat     = filter_input(INPUT_POST, 'alamat');
                                    $order      = filter_input(INPUT_POST, 'jumlahOrder');
                                    $stok       = filter_input(INPUT_POST, 'stok');
                                    if($order < $stok){   
                                        $q_in   = mysqli_query($connect, "INSERT INTO data_pesanan VALUES('', '$menu', '$price', '$order', '$tambahan', '$id_pemesan', '$pemesan', '$alamat', now())");
                                        $stok -= $order;
                                        if($q_in){
                                            $q_ink = mysqli_query($connect, "UPDATE katalog SET stok='$stok' WHERE id_katalog='$id_katalog'");
                                            if($q_ink) echo "Pemesanan Berhasil :)";
                                            else echo "Gagal Memesan!!";
                                        }   
                                    }else{
                                        echo $order." < ". $stok. "<br>".$pemesan;
                                        echo "Maaf, Stok saat ini belum tersedia.";
                                    }                     
                                }
                            ?>
                            <form method="post" action="">
                                <ul>
                                    <li>ID MENU</li>
                                    <li>:</li>
                                    <li><input type="text" value="<?php echo $id_katalog;?>" name="idmenu" readonly/></li>
                                </ul>
                                <ul>
                                    <li>MENU</li>
                                    <li>:</li>
                                    <li><input type="text" value="<?php echo $q_m['nama'];?>" name="menu" readonly/></</li>
                                </ul>
                                <ul>
                                    <li>Price (IDR)</li>
                                    <li>: Rp</li>
                                    <li><input type="text" name="harga" value="<?php echo number_format($q_m['harga'], 2, '.', '');?>" readonly/></li>
                                </ul>
                                <ul>
                                    <li>Pemesan</li>
                                    <li>:</li>
                                    <li><input type="text" name="pemesan" maxlength="50" value="<?php echo $_SESSION['nama'];?>" readonly/></li>
                                </ul>
                                <ul>
                                    <li>Tersedia</li>
                                    <li>:</li>
                                    <li><input type="text" name="stok" value="<?php echo $q_m['stok'];?>" readonly/></li>
                                </ul>
                                </ul>
                                <ul>
                                    <li>Jumlah Order</li>
                                    <li>:</li>
                                    <li><input type="number" name="jumlahOrder"/></li>
                                </ul>
                                <ul>
                                    <li>Tambahan</li>
                                    <li>:</li>
                                    <li><textarea name="tambahan"></textarea></li>
                                </ul>
                                <ul>
                                    <li>Alamat</li>
                                    <li>:</li>
                                    <li><textarea name="alamat"></textarea></li>
                                </ul>
                                <ul>
                                    <li class="pesan"><input type="submit" value="PESAN" name="submit"/></li>
                                </ul>
                            </form>
                            </div>
                        </div>
                    <?php
                        }else{
                            echo "<h1>Anda tidak memesan apapun!?</h1>";
                        }
                    break;
                    case "Minuman":
                    if(!empty($id_katalog)){
                        ?>
                        <div class="orderp">
                            <h3>Form Orders</h3>
                            <div class="prev-orderp"><img src="img/<?php echo $q_m['gambar'];?>" alt="<?php echo $q_m['nama'];?>" title="<?php echo $q_m['nama'];?>"/></div>
                            <div class="forms orderan">
                            <?php
                                if(!empty($_POST['submit'])&&isset($_POST['submit'])){
                                    $menu       = filter_input(INPUT_POST, 'menu');
                                    $price      = filter_input(INPUT_POST, 'harga');
                                    $id_pemesan = $_SESSION['id'];
                                    $pemesan    = filter_input(INPUT_POST, 'pemesan');
                                    $tambahan   = filter_input(INPUT_POST, 'tambahan');
                                    $alamat     = filter_input(INPUT_POST, 'alamat');
                                    $order      = filter_input(INPUT_POST, 'jumlahOrder');
                                    $stok       = filter_input(INPUT_POST, 'stok');
                                    if($order < $stok){   
                                        $q_in   = mysqli_query($connect, "INSERT INTO data_pesanan VALUES('', '$menu', '$price', '$order', '$tambahan', '$id_pemesan', '$pemesan', '$alamat', now())");
                                        $stok -= $order;
                                        if($q_in){
                                            $q_ink = mysqli_query($connect, "UPDATE katalog SET stok='$stok' WHERE id_katalog='$id_katalog'");
                                            if($q_ink) echo "Pemesanan Berhasil :)";
                                            else echo "Gagal Memesan!!";
                                        }   
                                    }else{
                                        echo $order." < ". $stok. "<br>".$pemesan;
                                        echo "Maaf, Stok saat ini belum tersedia.";
                                    }                     
                                }
                            ?>
                            <form method="post" action="">
                                <ul>
                                    <li>ID MENU</li>
                                    <li>:</li>
                                    <li><input type="text" value="<?php echo $id_katalog;?>" name="idmenu" readonly/></li>
                                </ul>
                                <ul>
                                    <li>MENU</li>
                                    <li>:</li>
                                    <li><input type="text" value="<?php echo $q_m['nama'];?>" name="menu" readonly/></</li>
                                </ul>
                                <ul>
                                    <li>Price (IDR)</li>
                                    <li>: Rp</li>
                                    <li><input type="text" name="harga" value="<?php echo number_format($q_m['harga'], 2, '.', '');?>" readonly/></li>
                                </ul>
                                <ul>
                                    <li>Pemesan</li>
                                    <li>:</li>
                                    <li><input type="text" name="pemesan" maxlength="50" value="<?php echo $_SESSION['nama'];?>" readonly/></li>
                                </ul>
                                <ul>
                                    <li>Tersedia</li>
                                    <li>:</li>
                                    <li><input type="text" name="stok" value="<?php echo $q_m['stok'];?>" readonly/></li>
                                </ul>
                                </ul>
                                <ul>
                                    <li>Jumlah Order</li>
                                    <li>:</li>
                                    <li><input type="number" name="jumlahOrder"/></li>
                                </ul>
                                <ul>
                                    <li>Tambahan</li>
                                    <li>:</li>
                                    <li><textarea name="tambahan"></textarea></li>
                                </ul>
                                <ul>
                                    <li>Alamat</li>
                                    <li>:</li>
                                    <li><textarea name="alamat"></textarea></li>
                                </ul>
                                <ul>
                                    <li class="pesan"><input type="submit" value="PESAN" name="submit"/></li>
                                </ul>
                            </form>
                            </div>
                        </div>
                    <?php
                        }else{
                            echo "<h1>Anda tidak memesan apapun!?</h1>";
                        }
                    break;
                    case "Kue-Cemilan":
                    if(isset($_GET['id'])&&!empty($_GET['id'])){
                        ?>
                        <div class="orderp">
                            <h3>Form Orders</h3>
                            <div class="prev-orderp"><img src="img/<?php echo $q_m['gambar'];?>" alt="<?php echo $q_m['nama'];?>" title="<?php echo $q_m['nama'];?>"/></div>
                            <div class="forms orderan">
                            <?php
                                if(!empty($_POST['submit'])&&isset($_POST['submit'])){
                                    $menu       = filter_input(INPUT_POST, 'menu');
                                    $price      = filter_input(INPUT_POST, 'harga');
                                    $id_pemesan = $_SESSION['id'];
                                    $pemesan    = filter_input(INPUT_POST, 'pemesan');
                                    $tambahan   = filter_input(INPUT_POST, 'tambahan');
                                    $alamat     = filter_input(INPUT_POST, 'alamat');
                                    $order      = filter_input(INPUT_POST, 'jumlahOrder');
                                    $stok       = filter_input(INPUT_POST, 'stok');
                                    if($order < $stok){   
                                        $q_in   = mysqli_query($connect, "INSERT INTO data_pesanan VALUES('', '$menu', '$price', '$order', '$tambahan', '$id_pemesan', '$pemesan', '$alamat', now())");
                                        $stok -= $order;
                                        if($q_in){
                                            $q_ink = mysqli_query($connect, "UPDATE katalog SET stok='$stok' WHERE id_katalog='$id_katalog'");
                                            if($q_ink) echo "Pemesanan Berhasil :)";
                                            else echo "Gagal Memesan!!";
                                        }   
                                    }else{
                                        echo $order." < ". $stok. "<br>".$pemesan;
                                        echo "Maaf, Stok saat ini belum tersedia.";
                                    }                     
                                }
                            ?>
                            <form method="post" action="">
                                <ul>
                                    <li>ID MENU</li>
                                    <li>:</li>
                                    <li><input type="text" value="<?php echo $id_katalog;?>" name="idmenu" readonly/></li>
                                </ul>
                                <ul>
                                    <li>MENU</li>
                                    <li>:</li>
                                    <li><input type="text" value="<?php echo $q_m['nama'];?>" name="menu" readonly/></</li>
                                </ul>
                                <ul>
                                    <li>Price (IDR)</li>
                                    <li>: Rp</li>
                                    <li><input type="text" name="harga" value="<?php echo number_format($q_m['harga'], 2, '.', '');?>" readonly/></li>
                                </ul>
                                <ul>
                                    <li>Pemesan</li>
                                    <li>:</li>
                                    <li><input type="text" name="pemesan" maxlength="50" value="<?php echo $_SESSION['nama'];?>" readonly/></li>
                                </ul>
                                <ul>
                                    <li>Tersedia</li>
                                    <li>:</li>
                                    <li><input type="text" name="stok" value="<?php echo $q_m['stok'];?>" readonly/></li>
                                </ul>
                                </ul>
                                <ul>
                                    <li>Jumlah Order</li>
                                    <li>:</li>
                                    <li><input type="number" name="jumlahOrder"/></li>
                                </ul>
                                <ul>
                                    <li>Tambahan</li>
                                    <li>:</li>
                                    <li><textarea name="tambahan"></textarea></li>
                                </ul>
                                <ul>
                                    <li>Alamat</li>
                                    <li>:</li>
                                    <li><textarea name="alamat"></textarea></li>
                                </ul>
                                <ul>
                                    <li class="pesan"><input type="submit" value="PESAN" name="submit"/></li>
                                </ul>
                            </form>
                            </div>
                        </div>
                        <?php
                    }else{
                        echo "<h1>Anda tidak memesan apapun!?</h1>";
                    }
                    break;
                    default:
                        header("Location: index.php?p=home");    
                }
                ?>
            </div>
            <?php
             } else{
                header("Location: index.php?op=login");
            }
            ?>
        </section>
        <footer>
            <div class="footer">
               <?php require_once "footer.php";?>
            </div>
        </footer>
    </div>

</body>
</html>