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
                            <?php
                             $q = mysqli_query($rm->connectionDB(), "SELECT * FROM data_member");
                            if($q){
                                if(mysqli_num_rows($q) > 0){
                            ?>
                                <table border="1">
                                    <tr>
                                        <th>No</th>
                                        <th>Username</th>
                                        <th>Nama Lengkap</th>
                                        <th>Email</th>
                                        <th>No HP</th>
                                        <th>Domisili</th>
                                        <th>Alamat</th>
                                        <th colspan='2'>Action</th>
                                    </tr>     
                            <?php
                                    while($data = mysqli_fetch_array($q)){
                            ?>
                                    <tr>
                                        <td><?php echo $data['id'];?></td>
                                        <td><?php echo $data['username'];?></td>
                                        <td><?php echo $data['nama_lengkap'];?></td>
                                        <td><?php echo $data['email'];?></td>
                                        <td><?php echo $data['hp'];?></td>
                                        <td><?php echo $data['domisili'];?></td>
                                        <td><?php echo $data['alamat'];?></td>
                                        <?php
                                            echo 
                                                "<td><a href='control-member.php?p=delete&id=".$data['id']."' onclick='return confirm(\"Apa Yakin ingin menghapus member ini?\")'>Delete</a></td>
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
                            case "delete":
                            if(!isset($_GET['id'])) header("Location: control-member.php?p=show");
							$id = addslashes(strip_tags($_GET['id']));

							$q_s = mysqli_query($rm->connectionDB(),"SELECT * FROM katalog WHERE id_katalog='$id'");
							$q_sef = mysqli_fetch_array($q_s);
							if(unlink("img/$q_sef[gambar]")){
							$query = mysqli_query($rm->connectionDB(),"DELETE FROM katalog WHERE id='$id'");
								if($query)
									header("Location:control-katalog.php?p=show");
								else
									echo "So-sorry <a href='javascript:history.back()'>Kembali</a>";
							}else{
								echo "adanya yang salah bro! <br/><a href='javascript:history.back()'>Kembali</a>";
							}
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