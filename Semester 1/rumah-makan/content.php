                <div class="katalog">
                    <p class="first">Selamat Datang, <?php echo $_SESSION['nama']; ?></p>
                    <div class="orders">
                        <div class="order-thead tops">
                            <h3>Top Order</h3>
                            <a href="index.php?menu=top" class="right">More</a>
                        </div>
                        <?php 
                        for($i = 1; $i <= 3; $i++){
                        ?>
                        <div class="box box-top">
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
                    <div class="orders" style="margin-bottom: 0px;">
                        <div class="order-thead fr">
                            <h2>Recent Add</h2>
                            <a href="index.php?menu=top" class="right">More</a>
                        </div>
                        <?php 
                        $query = mysqli_query($rm->connectionDB(), "SELECT * FROM katalog ORDER BY tanggal DESC LIMIT 0,5");
                        while($dt = mysqli_fetch_array($query)){
                        ?>
                        <div class="box box-content">
                            <div class="names">
                                <h2><a href="pesan.php?menu=<?php echo $dt['menu'];?>&id=<?php echo $dt['id_katalog'];?>" title="<?php echo $dt['nama'];?>"><?php echo $dt['nama'];?></a></h2>
                            </div>
                            <div class="info">
                                <p>
                                    <span class="left">Rp <?php echo number_format($dt['harga'], 0, ",", ".");?></span>
                                    <span class="right">4.5</span>
                                </p>
                            </div>
                            <div class="prev">
                                <a href="pesan.php?menu=<?php echo $dt['menu'];?>&id=<?php echo $dt['id_katalog'];?>"><img src="img/<?php echo $dt['gambar'];?>" alt="<?php echo $dt['nama'];?>t"/></a>
                            </div>
                            <div class="info">
                                <p><a href="pesan.php?menu=<?php echo $dt['menu'];?>&id=<?php echo $dt['id_katalog'];?>">ORDER<br>Tersedia : <?php echo $dt['stok']." ".substr($dt['nama'], 0, 10);?> </a></p>
                            </div>
                        </div>
                        <?php } ?>
                    </div>
                    <div class="clearfix"></div>
                    <div class="orders">
                        <div class="order-thead">
                            <h3>Makanan</h3>
                            <a href="index.php?menu=top" class="right">More</a>
                        </div>
                        <?php 
                        $q_m = mysqli_query($rm->connectionDB(),"SELECT * FROM katalog WHERE menu='Makanan' ORDER BY tanggal DESC");
                        if(mysqli_num_rows($q_m) > 0){
                            while($dm = mysqli_fetch_array($q_m)){
                            ?>
                            <div class="box box-content">
                                <div class="names">
                                    <h2><a href="pesan.php?menu=<?php echo $dm['menu'];?>&id=<?php echo $dm['id_katalog'];?>" title="<?php echo $dm['nama'];?>"><?php echo $dm['nama'];?></a></h2>
                                </div>
                                <div class="info">
                                    <p>
                                        <span class="left">Rp <?php echo number_format($dm['harga'], 0, ",", ".");?></span>
                                        <span class="right">4.5</span>
                                    </p>
                                </div>
                                <div class="prev">
                                    <a href="pesan.php?menu=<?php echo $dm['menu'];?>&id=<?php echo $dm['id_katalog'];?>"><img src="img/<?php echo $dm['gambar'];?>" alt="<?php echo $dm['nama'];?>t"/></a>
                                </div>
                                <div class="info">
                                    <p><a href="pesan.php?menu=<?php echo $dm['menu'];?>&id=<?php echo $dm['id_katalog'];?>">ORDER<br>Tersedia : <?php echo $dm['stok']." ".substr($dm['nama'],0,10);?></a></p>
                                </div>
                            </div>
                            <?php } 
                        }else{
                            echo "<div class='info-k'><p>Data Belum tersedia</p></div>";
                        }
                        ?>
                    </div>
                    <div class="clearfix"></div>
                    <div class="orders">
                        <div class="order-thead">
                            <h3>Minuman</h3>
                            <a href="index.php?menu=top" class="right">More</a>
                        </div>
                        <?php 
                        $q_m = mysqli_query($rm->connectionDB(),"SELECT * FROM katalog WHERE menu='Minuman' ORDER BY tanggal DESC");
                        if(mysqli_num_rows($q_m) > 0){
                            while($dm = mysqli_fetch_array($q_m)){
                            ?>
                            <div class="box box-content">
                                <div class="names">
                                    <h2><a href="pesan.php?menu=<?php echo $dm['menu'];?>&id=<?php echo $dm['id_katalog'];?>" title="<?php echo $dm['nama'];?>"><?php echo $dm['nama'];?></a></h2>
                                </div>
                                <div class="info">
                                    <p>
                                        <span class="left">Rp <?php echo number_format($dm['harga'], 0, ",", ".");?></span>
                                        <span class="right">4.5</span>
                                    </p>
                                </div>
                                <div class="prev">
                                    <a href="pesan.php?menu=<?php echo $dm['menu'];?>&id=<?php echo $dm['id_katalog'];?>"><img src="img/<?php echo $dm['gambar'];?>" alt="<?php echo $dm['nama'];?>t"/></a>
                                </div>
                                <div class="info">
                                    <p><a href="pesan.php?menu=<?php echo $dm['menu'];?>&id=<?php echo $dm['id_katalog'];?>">ORDER<br>Tersedia : <?php echo $dm['stok']." ".substr($dm['nama'], 0, 10);?></a></p>
                                </div>
                            </div>
                    <?php }
                        }else{
                            echo "<div class='info-k'><p>Data Belum tersedia</p></div>";
                        }
                    ?>
                    </div>
                    <div class="clearfix"></div>
                    <div class="orders">
                        <div class="order-thead">
                            <h3>Kue dan Cemilan</h3>
                            <a href="index.php?menu=top" class="right">More</a>
                        </div>
                        <?php 
                        $q_kc = mysqli_query($rm->connectionDB(),"SELECT * FROM katalog WHERE menu='Kue-Cemilan' ORDER BY tanggal DESC");
                        if(mysqli_num_rows($q_kc) > 0){
                            while($dkc = mysqli_fetch_array($q_kc)){
                            ?>
                            <div class="box box-content">
                                <div class="names">
                                    <h2><a href="pesan.php?menu=<?php echo $dkc['menu'];?>&id=<?php echo $dkc['id_katalog'];?>" title="<?php echo $dkc['nama'];?>"><?php echo $dkc['nama'];?></a></h2>
                                </div>
                                <div class="info">
                                    <p>
                                        <span class="left">Rp <?php echo number_format($dkc['harga'], 0, ",", ".");?></span>
                                        <span class="right">4.5</span>
                                    </p>
                                </div>
                                <div class="prev">
                                    <a href="pesan.php?menu=<?php echo $dkc['menu'];?>&id=<?php echo $dkc['id_katalog'];?>"><img src="img/<?php echo $dkc['gambar'];?>" alt="<?php echo $dkc['nama'];?>t"/></a>
                                </div>
                                <div class="info">
                                    <p><a href="pesan.php?menu=<?php echo $dkc['menu'];?>&id=<?php echo $dkc['id_katalog'];?>">ORDER<br>Tersedia : <?php echo $dkc['stok']." ".substr($dkc['nama'], 0, 10);?></a></p>
                                </div>
                            </div>
                    <?php }
                         }else{
                            echo "<div class='info-k'><p>Data Belum tersedia</p></div>";
                        } 
                    ?>
                    </div>
                </div>