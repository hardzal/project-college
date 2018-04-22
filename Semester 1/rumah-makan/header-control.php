<?php
ob_start();
session_start();
require_once "class.php";
$rm = new rumahMakan;
$connect = $rm->connectionDB();
if(!$rm->checkLogin()){
    header("Location: index.php?p=login");
}
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
        <section>
            <header>
                <div class="header">
                    <h1>Control Panel</h1>
                </div>
            </header>
            <nav>
                <div class="menu">
                    <ul>
                        <li><a href="control.php">Dashboard</a></li>
                        <li><a href="control-katalog.php">Control Katalog</a></li>                        
                        <li><a href="control-pesanan.php">List Order</a></li>
                        <li><a href="control-member.php">List Member</a></li>
                        <li><a href="control-kontak.php">Contact</a></li>
                        <li><a href="index.php?p=logout">Logout</a></li>
                    </ul>
                </div>
            </nav>