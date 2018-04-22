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
                        <h3>Data Contact</h3>
                            <?php
                             $q = mysqli_query($rm->connectionDB(), "SELECT * FROM kontak");
                            if($q){
                                if(mysqli_num_rows($q) > 0){
                            ?>
                                <table border="1">
                                    <tr>
                                        <th>Alamat</th>
                                        <th>Facebook</th>
                                        <th>Instagram</th>
                                        <th>Twitter</th>
                                        <th>Email</th>
                                        <th>Telpon</th>
                                        <th>Action</th>
                                    </tr>     
                            <?php
                                    while($data = mysqli_fetch_array($q)){
                            ?>
                                    <tr>
                                        <td><?php echo $data['alamat'];?></td>
                                        <td><?php echo $data['fb'];?></td>
                                        <td><?php echo $data['instagram'];?></td>
                                        <td><?php echo $data['twitter'];?></td>
                                        <td><?php echo $data['email'];?></td>
                                        <td><?php echo $data['telp'];?></td>
                                        <?php
                                            echo 
                                                "<td><a href='control-kontak.php?p=edit&id=".$data['id']."'>Edit</a></td>
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
                            
                            case "edit":
                            if(!isset($_GET['id'])) header("Location: control-kontak.php?p=show");
							$id = addslashes(strip_tags($_GET['id']));

							$q_s = mysqli_query($rm->connectionDB(),"SELECT * FROM kontak WHERE id='$id'");
							$q_sef = mysqli_fetch_array($q_s);
                        ?>
                            <h3>Form Edit Katalog</h3>
                        <?php
                            if(isset($_POST['submit'])){
                                $alamat = filter_input(INPUT_POST, 'alamat');
                                $ig     = filter_input(INPUT_POST, 'instagram');
                                $fb     = filter_input(INPUT_POST, 'fb');
                                $tw     = filter_input(INPUT_POST, 'twitter');
                                $telp   = filter_input(INPUT_POST, 'telp');
                                $email  = filter_input(INPUT_POST, 'email');

                                $query  = mysqli_query($rm->connectionDB(),"UPDATE kontak SET alamat='$alamat', instagram='$ig', fb='$fb', twitter='$tw', email='$email', telp='$telp' WHERE id='$id'");
                                if($query){
                                    echo "<p>Data telah di Update!</p>";
                                }else{
                                    echo "Ada yang salah<br/><a href='javascript:history.back()'>Kembali</a>";
                                }
                        
                            }
                        ?>
                        <div class="form-add">
                            <form method="post" action="" enctype='multipart/form-data'>
                               <ul>
                                    <li>Facebook</li>
                                    <li><input type="text" value="<?php echo $q_sef['fb'];?>" name="fb"/></li>
                                </ul>
                                <ul>
                                    <li>Twitter</li>
                                    <li><input type="text" value="<?php echo $q_sef['twitter'];?>" name="twitter"/></li>
                                </ul>
                                <ul>
                                    <li>Instagram</li>
                                    <li><input type="text" value="<?php echo $q_sef['instagram'];?>" name="instagram"/></li>
                                </ul>
                                <ul>
                                    <li>Email</li>
                                    <li><input type="email" value="<?php echo $q_sef['email'];?>" name="email"/></li>
                                </ul>
                                <ul>
                                    <li>No Telp</li>
                                    <li><input type="text" name="telp" value="<?php echo $q_sef['telp'];?>"/></li>
                                </ul>
                                <ul>
                                    <li>Alamat</li>
                                    <li><textarea name="alamat"><?php echo $q_sef['alamat'];?></textarea></li>
                                </ul>
                                <input type="hidden" value="<?php echo $id;?>" name="id"/>
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