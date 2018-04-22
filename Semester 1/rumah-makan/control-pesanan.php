<?php require "header-control.php";?>
            <div class="content">
                <p class="first">Welcome, <?php echo $_SESSION['nama'];?></p>
                <div class="board">
                    <?php
                        $p = isset($_GET['p']) ? $_GET['p'] : "";
                        if($p ==""){
                            $p = "show";
                        }
                        switch($p){
                            case "show":
                        ?>
                        <h3>Data Pesanan</h3>
                            <?php
                             $q = mysqli_query($rm->connectionDB(), "SELECT * FROM data_pesanan ORDER BY tanggal");
                             
                            if($q){
                                if(mysqli_num_rows($q) > 0){
                            ?>
                                <table border="1">
                                    <tr>
                                        <th>No</th>
                                        <th>Nama Pemesan</th>
                                        <th>Pesanan</th>
                                        <th>Jumlah Order</th>
                                        <th>Harga Total</th>
                                        <th>Tambahan</th>
                                        <th colspan='3'>Action</th>
                                    </tr>     
                            <?php
                                    while($data = mysqli_fetch_array($q)){
                                    if($data['status']){
                                        $status = "Terkirim";
                                    }else{
                                        $status = "Belum Terkirim";
                                    }
                            ?>
                                    <tr>
                                        <td><?php echo $data['id_pesanan'];?></td>
                                        <td><?php echo $data['nama_pemesan'];?></td>
                                        <td><?php echo $data['nama_menu'];?></td>
                                        <td><?php echo $data['jumlah_order'];?></td>
                                        <td><?php echo $data['jumlah_order']*$data['harga_menu'];?></td>
                                        <td><?php echo $data['tambahan'];?></td>
                                        <?php
                                            echo 
                                                "<td><a href='control-pesanan.php?p=edit&id=".$data['id_pesanan']."'>Edit</a></td>
                                                <td><a href='control-pesanan.php?p=delete&id=".$data['id_pesanan']."' onclick='return confirm(\"Apa Yakin ingin menghapus photo ini?\")'>Delete</a></td>
                                                <td>".$status."</td>
                                            ";
                                        ?>
                                </tr>
                            <?php
                                    }
                            ?>
                            </table>
                            <?php
                                }else{
                                ?>
                                <strong>Data Belum tersedia!</strong>
                                <?php
                                }
                            }else{
                                echo mysqli_error($rm->connectionDB());
                            }
                                break;
                            case "add":
                        ?>
                            <h3>Form Add Katalog</h3>
                        <?php
                            if(isset($_POST['submit'])){
                                $dir = "img/";
                                $img_name = $_FILES['img']['name'];
                                $img_type = $_FILES['img']['type'];
                                $img_size = $_FILES['img']['size'];
                                $img_tmp = $_FILES['img']['tmp_name'];
                                $nama_menu = filter_input(INPUT_POST, 'nama_menu');
                                $price     = filter_input(INPUT_POST, 'harga');
                                $category = filter_input(INPUT_POST, 'jenis_menu');
                                $detail = filter_input(INPUT_POST, 'detail');
                                
                                if(move_uploaded_file($img_tmp,$dir.$img_name)){
                                    $query = mysqli_query($rm->connectionDB(),"INSERT INTO katalog VALUES('','$nama_menu','$detail','$price', '$category', '$img_name', now())");
                                    if($query)
                                        echo "<p>Berhasil Menambah Data!</p>";
                                    else
                                        echo "Gagal Menambah Data!";
                                }
                            }
                        ?>
                        <div class="form-add">
                            <form method="post" action="" enctype='multipart/form-data'>
                                <ul>
                                    <li>Nama Menu</li>
                                    <li><input type="text" name="nama_menu" maxlength="100" placeholder="nama menu..." required/></li>
                                </ul>
                                <ul>
                                    <li>Price</li>
                                    <li><input type="text" name="harga" maxlength="15" required/></li>
                                </ul>
                                <ul>
                                    <li>Nama Menu</li>
                                    <li><select name="jenis_menu">
                                        <option value="Makanan">Makanan</option>
                                        <option value="Minuman">Minuman</option>
                                        <option value="kue-cemilan">Kue dan Cemilan</option>  
                                       </select>  
                                    </li>
                                </ul>
                                <ul>
                                    <li>Preview</li>
                                    <li><input type="file" name="img"/></li>   
                                    </li>
                                </ul>
                                <ul>
                                    <li>Details</li>
                                    <li><textarea name="detail" required></textarea></li>
                                </ul>
                                
                                <input type="submit" name="submit" value="INPUT" style="width: 300px;"/>
                                
                            </form> 
                        </div>  
                        <?php
                                break;
                            case "delete":
                            if(!isset($_GET['id'])) header("Location: control-pesanan.php?p=show");
							$id = addslashes(strip_tags($_GET['id']));
							$query = mysqli_query($rm->connectionDB(),"DELETE FROM data_pesanan WHERE id_pesanan='$id'");
                            if($query)
                                header("Location:control-pesanan.php?p=show");
                            else
                                echo "So-sorry <a href='javascript:history.back()'>Kembali</a>";
                                break;
                            case "edit":
                            if(!isset($_GET['id'])) header("Location: control-pesanan.php.php?p=show");
							$id = addslashes(strip_tags($_GET['id']));

							$q_s = mysqli_query($rm->connectionDB(),"SELECT * FROM data_pesanan WHERE id_pesanan='$id'");
                            $q_sef = mysqli_fetch_array($q_s);
                            if($q_sef['status']){
                                $selected = array("", "selected");
                            }else{
                                $selected = array("selected", "");
                            }
                        ?>
                            <h3>Form Update Katalog</h3>
                        <?php
                            if(isset($_POST['submit'])){
                                $id = filter_input(INPUT_POST, 'id_pesanan');
                                $query = mysqli_query($rm->connectionDB(),"UPDATE data_pesanan SET status=1 WHERE id_pesanan='$id'");
                                if($query){
                                    echo "<p>Data telah di Update!</p>";
                                }else{
                                    echo "Ada yang salah<br/><a href='javascript:history.back()'>Kembali</a>";
                                }
                            }
                        ?>
                        <div class="form-add">
                            <form method="post" action="">
                                <ul>
                                    <li>Status</li>
                                    <li><select name="status">
                                        <option value=0 <?php echo $selected[0];?>>Belum dikirim</option>
                                        <option value=1 <?php echo $selected[1];?>>Terkirim</option>
                                        </select>
                                    </li>
                                </ul>
                                <input type="hidden" value="<?php echo $id;?>" name="id_pesanan"/>
                                <input type="submit" name="submit" value="INPUT" style="width: 300px;"/>
                            </form> 
                        </div>  
                        <?php
                                break;
                          
                        }
                    ?>
                </div>
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