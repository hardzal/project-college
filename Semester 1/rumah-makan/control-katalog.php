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
                        <h3>Data Katalog</h3>
                        <div class="info" style="width: 50%; margin-bottom: 20px;">
                            <p><a href="control-katalog.php?p=add" title="Add Katalog">Add Katalog</a></p>
                        </div>
                            <?php
                             $q = mysqli_query($rm->connectionDB(), "SELECT * FROM katalog ORDER BY tanggal DESC");
                            if($q){
                                if(mysqli_num_rows($q) > 0){
                            ?>
                                <table border="1">
                                    <tr>
                                        <th>ID Menu</th>
                                        <th>Menu</th>
                                        <th>Category</th>
                                        <th>Price</th>
                                        <th>Stok</th>
                                        <th>Detail</th>
                                        <th>Preview</th>
                                        <th colspan='2'>Action</th>
                                    </tr>     
                            <?php
                                    while($data = mysqli_fetch_array($q)){
                            ?>
                                    <tr>
                                        <td><?php echo $data['id_katalog'];?></td>
                                        <td><?php echo $data['nama'];?></td>
                                        <td><?php echo $data['menu'];?></td>
                                        <td><?php echo $data['harga'];?></td>
                                        <td><?php echo $data['stok'];?></td>
                                        <td><?php echo $data['detail'];?></td>
                                        <td style="text-align: center;" class="tc"><?php echo '<img src="img/'.$data['gambar'].'" alt="'.$data['nama'].'"/>';?></td>
                                        <?php
                                            echo 
                                                "<td><a href='control-katalog.php?p=edit&id=".$data['id_katalog']."'>Edit</a></td>
                                                <td><a href='control-katalog.php?p=delete&id=".$data['id_katalog']."' onclick='return confirm(\"Apa Yakin ingin menghapus data ini?\")'>Delete</a></td>
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
                                $stok      = filter_input(INPUT_POST, 'stok');
                                $category  = filter_input(INPUT_POST, 'jenis_menu');
                                $detail    = filter_input(INPUT_POST, 'detail');
                                
                                if(move_uploaded_file($img_tmp,$dir.$img_name)){
                                    $query = mysqli_query($rm->connectionDB(),"INSERT INTO katalog VALUES('','$nama_menu','$detail','$price', '$stok', $category', '$img_name', now())");
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
                                    <li>Stok</li>
                                    <li><input type="number" name="stok" maxlength="15" required/></li>
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
                            if(!isset($_GET['id'])) header("Location: control-katalog.php?p=show");
							$id = addslashes(strip_tags($_GET['id']));

							$q_s = mysqli_query($rm->connectionDB(),"SELECT * FROM katalog WHERE id_katalog='$id'");
							$q_sef = mysqli_fetch_array($q_s);
							if(unlink("img/$q_sef[gambar]")){
							$query = mysqli_query($rm->connectionDB(),"DELETE FROM katalog WHERE id_katalog='$id'");
								if($query)
									header("Location:control-katalog.php?p=show");
								else
									echo "So-sorry <a href='javascript:history.back()'>Kembali</a>";
							}else{
								echo "adanya yang salah bro! <br/><a href='javascript:history.back()'>Kembali</a>";
							}
                                break;
                            case "edit":
                            if(!isset($_GET['id'])) header("Location: control-katalog.php?p=show");
							$id = addslashes(strip_tags($_GET['id']));

							$q_s = mysqli_query($rm->connectionDB(),"SELECT * FROM katalog WHERE id_katalog='$id'");
                            $q_sef = mysqli_fetch_array($q_s);
                            if($q_sef['menu'] == 'Makanan'){
                                $selected = array("selected", "", "");
                            }else if($q_sef['menu'] == 'Minuman'){
                                $selected = array("", "selected", "");
                            }else if($q_sef['menu'] == 'kue-cemilan'){
                                $selected = array("", "", "selected");
                            }else{
                                $selected = array("", "", "");
                            }
                        ?>
                            <h3>Form Update Katalog</h3>
                        <?php
                            if(isset($_POST['submit'])){
                                $dir = "img/";
                                $img_name = $_FILES['img']['name'];
                                $img_type = $_FILES['img']['type'];
                                $img_size = $_FILES['img']['size'];
                                $img_tmp = $_FILES['img']['tmp_name'];
                                $id_katalog = filter_input(INPUT_POST, 'id_katalog');
                                $nama_menu  = filter_input(INPUT_POST, 'nama_menu');
                                $price      = filter_input(INPUT_POST, 'harga');
                                $stok       = filter_input(INPUT_POST, 'stok');
                                $category   = filter_input(INPUT_POST, 'jenis_menu');
                                $detail     = filter_input(INPUT_POST, 'detail');
                                
                                if($nama_menu!=""&&$price!=""){
                                    
                                    $query = mysqli_query($rm->connectionDB(),"UPDATE katalog SET nama='$nama_menu', detail='$detail', harga='$price', stok='$stok', menu='$category', tanggal=now() WHERE id_katalog='$id_katalog'") or die(mysqli_error($rm->connectionDB()));

									if(isset($img_tmp)&&!empty($img_tmp)&&!empty($img_name)){
                                        move_uploaded_file($img_tmp,$dir.$img_name);
                                        unlink("img/$q_sef[gambar]");
                                        $query_image = mysqli_query($rm->connectionDB(),"UPDATE katalog SET gambar='$img_name' WHERE id_katalog='$id_katalog'");
                                    }
                                    
										if($query){
											echo "<p>Data telah di Update!</p>";
										}else{
											echo "Ada yang salah<br/><a href='javascript:history.back()'>Kembali</a>";
										}
								}else{
									echo $_FILES['gambar']['error']."<br/>";
									echo "Form Harus diisi dengan seluruhnya dengan benar <br/>
											<a href='javascript:history.back()'>Kembali</a>";
								}
                            }
                        ?>
                        <div class="form-add">
                            <form method="post" action="" enctype='multipart/form-data'>
                                <ul>
                                    <li>Nama Menu</li>
                                    <li><input type="text" name="nama_menu" maxlength="100" placeholder="nama menu..." value="<?php echo $q_sef['nama'];?>" required></li>
                                </ul>
                                <ul>
                                    <li>Price</li>
                                    <li><input type="text" name="harga" maxlength="15" value="<?php echo $q_sef['harga'];?>" required/></li>
                                </ul>
                                <ul>
                                    <li>Stok</li>
                                    <li><input type="number" name="stok" maxlength="15" value="<?php echo $q_sef['stok'];?>" required/></li>
                                </ul>
                                <ul>
                                    <li>Nama Menu</li>
                                    <li><select name="jenis_menu">
                                        <option value="Makanan" <?php echo $selected[0];?>>Makanan</option>
                                        <option value="Minuman" <?php echo $selected[1];?>>Minuman</option>
                                        <option value="Kue-Cemilan" <?php echo $selected[2];?>>Kue dan Cemilan</option>  
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
                                    <li><textarea name="detail" required><?php echo $q_sef['detail'];?></textarea></li>
                                </ul>
                                <input type="hidden" value="<?php echo $q_sef['id_katalog'];?>" name="id_katalog"/>
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