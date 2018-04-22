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
        <div class="katalog">
        <?php
            require_once "header.php";
            require "navigasi.php";
        ?>
        <section>
            <?php
            if($rm->checkLogin()){
            ?>
            <div class="content">
                <div class="katalog">
                <?php 
                $options = isset($_GET['menu']) ? $_GET['menu'] : "";
                if($options ==""){
                    $options = "all";
                }
                switch($options){
                    case "all":
                ?>
                <div class="orders">
                    <div class="order-thead">
                        <h3>Makanan</h3>
                        <a href="index.php?menu=top" class="right">More</a>
                    </div>
                    <?php 
                    for($i = 1; $i <= 5; $i++){
                    ?>
                    <div class="box box-content">
                        <div class="names">
                            <h2><a href="pesan.php?menu=makanan&id=1" title="Ayam Rendang!">Ayam Rendang!</a></h2>
                        </div>
                        <div class="info">
                            <p>
                                <span class="left">Rp 50.000</span>
                                <span class="right">4.5</span>
                            </p>
                        </div>
                        <div class="prev">
                            <a href="pesan.php?menu=makanan&id=1"><img src="img/default.jpg" alt="Makanan Default"/></a>
                        </div>
                        <div class="info">
                            <p><a href="pesan.php?menu=makanan&id=1">ORDER</a></p>
                        </div>
                    </div>
                    <?php } ?>
                </div>
                <div class="clearfix"></div>
                <div class="orders">
                    <div class="order-thead">
                        <h3>Minuman</h3>
                        <a href="index.php?menu=top" class="right">More</a>
                    </div>
                    <?php 
                    for($i = 1; $i <= 5; $i++){
                    ?>
                    <div class="box box-content">
                        <div class="names">
                            <h2><a href="pesan.php?menu=makanan&id=1" title="Ayam Rendang!">Ayam Rendang!</a></h2>
                        </div>
                        <div class="info">
                            <p>
                                <span class="left">Rp 50.000</span>
                                <span class="right">4.5</span>
                            </p>
                        </div>
                        <div class="prev">
                            <a href="pesan.php?menu=makanan&id=1"><img src="img/default.jpg" alt="Makanan Default"/></a>
                        </div>
                        <div class="info">
                            <p><a href="pesan.php?menu=makanan&id=1">ORDER</a></p>
                        </div>
                    </div>
                    <?php } ?>
                </div>
                <div class="clearfix"></div>
                <div class="orders">
                    <div class="order-thead">
                        <h3>Kue dan Cemilan</h3>
                        <a href="index.php?menu=top" class="right">More</a>
                    </div>
                    <?php 
                    for($i = 1; $i <= 5; $i++){
                    ?>
                    <div class="box box-content">
                        <div class="names">
                            <h2><a href="pesan.php?menu=makanan&id=1" title="Ayam Rendang!">Ayam Rendang!</a></h2>
                        </div>
                        <div class="info">
                            <p>
                                <span class="left">Rp 50.000</span>
                                <span class="right">4.5</span>
                            </p>
                        </div>
                        <div class="prev">
                            <a href="pesan.php?menu=makanan&id=1"><img src="img/default.jpg" alt="Makanan Default"/></a>
                        </div>
                        <div class="info">
                            <p><a href="pesan.php?menu=makanan&id=1">ORDER</a></p>
                        </div>
                    </div>
                    <?php } ?>
                </div>
                <?php                       
                    break;
                    case "makanan":
                ?>
                     <div class="orders">
                        <div class="order-thead">
                            <h3>Makanan</h3>
                            <a href="index.php?menu=top" class="right">More</a>
                        </div>
                        <?php 
                        for($i = 1; $i <= 5; $i++){
                        ?>
                        <div class="box catalog">
                            <div class="names">
                                <h2><a href="pesan.php?menu=makanan&id=1" title="Ayam Rendang!">Ayam Rendang!</a></h2>
                            </div>
                            <div class="catalog-prev">
                                <a href="pesan.php?menu=makanan&id=1"><img src="img/default.jpg" alt="Makanan Default"/></a>
                            </div>
                            <div class="catalog-details">
                                <ul>
                                    <li>ID MENU</li>
                                    <li>:</li>
                                    <li>1234</li>
                                </ul>
                                <ul>
                                    <li>MENU</li>
                                    <li>:</li>
                                    <li>Ayam Rendang Cap Joss!</li>
                                </ul>
                                <ul>
                                    <li>Details</li>
                                    <li>:</li>
                                    <li>Makanan yang paling enak sedunia ini tidak ada tergantikan, dengan olahan yang sangat sedap dan pastinya sehat</li>
                                </ul>
                                <ul>
                                    <li>Price</li>
                                    <li>:</li>
                                    <li>Rp 50.000,00</li>
                                </ul>
                                <ul>
                                    <li>Rate</li>
                                    <li>:</li>
                                    <li>4.5</li>
                                </ul>
                                <div class="info">
                                    <p><a href="pesan.php?menu=makanan&id=1">ORDER</a></p>
                                </div>
                            </div>
                        </div>
                    <?php } ?>
                </div>
                <?php break;
                case "minuman":
                ?>
                <div class="orders">
                    <div class="order-thead">
                        <h3>Minuman</h3>
                        <a href="index.php?menu=top" class="right">More</a>
                    </div>
                    <?php 
                    for($i = 1; $i <= 5; $i++){
                    ?>
                    <div class="box catalog">
                        <div class="names">
                            <h2><a href="pesan.php?menu=makanan&id=1" title="Es Campur Cap Joss!">Es Campur Cap Joss!</a></h2>
                        </div>
                        <div class="catalog-prev">
                            <a href="pesan.php?menu=makanan&id=1"><img src="img/default.jpg" alt="Makanan Default"/></a>
                        </div>
                        <div class="catalog-details">
                            <ul>
                                <li>ID MENU</li>
                                <li>:</li>
                                <li>1234</li>
                            </ul>
                            <ul>
                                <li>MENU</li>
                                <li>:</li>
                                <li>Es Campur Cap Joss!</li>
                            </ul>
                            <ul>
                                <li>Details</li>
                                <li>:</li>
                                <li>Minuman yang paling enak sedunia ini tidak ada tergantikan, dengan olahan yang sangat sedap dan pastinya sehat</li>
                            </ul>
                            <ul>
                                <li>Price</li>
                                <li>:</li>
                                <li>Rp 50.000,00</li>
                            </ul>
                            <ul>
                                <li>Rate</li>
                                <li>:</li>
                                <li>4.5</li>
                            </ul>
                            <div class="info">
                                <p><a href="pesan.php?menu=makanan&id=1">ORDER</a></p>
                            </div>
                        </div>
                     </div>
                    <?php } ?>
                </div>
                <?php
                break;
                case "kue-cemilan":
                ?>
                <div class="orders">
                    <div class="order-thead">
                        <h3>Kue dan Cemilan</h3>
                        <a href="index.php?menu=top" class="right">More</a>
                    </div>
                    <?php 
                    for($i = 1; $i <= 5; $i++){
                    ?>
                    <div class="box catalog">
                    <div class="names">
                        <h2><a href="pesan.php?menu=makanan&id=1" title="Es Campur Cap Joss!">Martabak Manis Joss!</a></h2>
                    </div>
                    <div class="catalog-prev">
                        <a href="pesan.php?menu=makanan&id=1"><img src="img/default.jpg" alt="Makanan Default"/></a>
                    </div>
                    <div class="catalog-details">
                        <ul>
                            <li>ID MENU</li>
                            <li>:</li>
                            <li>1234</li>
                        </ul>
                        <ul>
                            <li>MENU</li>
                            <li>:</li>
                            <li>Martabak Manis Joss!</li>
                        </ul>
                        <ul>
                            <li>Details</li>
                            <li>:</li>
                            <li>Minuman yang paling enak sedunia ini tidak ada tergantikan, dengan olahan yang sangat sedap dan pastinya sehat</li>
                        </ul>
                        <ul>
                            <li>Price</li>
                            <li>:</li>
                            <li>Rp 50.000,00</li>
                        </ul>
                        <ul>
                            <li>Rate</li>
                            <li>:</li>
                            <li>4.5</li>
                        </ul>
                        <div class="info">
                            <p><a href="pesan.php?menu=makanan&id=1">ORDER</a></p>
                        </div>
                    </div>
                    </div>
                    <?php } ?>
                </div>
                <?php
                break;
                default: 
                    header("Location: katalog.php?menu=all");
                ?>
               <?php } ?>
                </div>
            </div>
            <?php
            }else {
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