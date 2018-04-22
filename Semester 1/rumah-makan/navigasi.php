            <nav>
                <div class="menu">
                    <ul>
                        <li><a href="index.php">Home</a></li>
                        <li><a href="katalog.php?menu=all">Katalog</a>
                            <ul>
                                <li><a href="katalog.php?menu=makanan">Makanan</a></li>
                                <li><a href="katalog.php?menu=minuman">Minuman</a></li>
                                <li><a href="katalog.php?menu=kue-cemilan">Kue dan Cemilan</a></li>
                            </ul>
                        </li>
                        <li><a href="contact.php">Contact</a></li>
                        <li><a href="index.php#about">About</a></li>
                        <?php if($rm->checkLogin()) {?>
                            <li><a href="control.php">Control</a></li>
                            <li><a href='index.php?p=logout' onclick='return confirm(\"Apa Kamu yakin ingin Logout?\")'>Logout</a> <?php }
                        else {?> 
                            <li><a href="index.php?p=login">Login</a></li>
                            <li><a href="index.php?p=register">Register</a></li>                        
                        <?php } ?>
                    </ul>
                </div>
            </nav>