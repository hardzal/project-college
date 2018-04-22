<?php require "header-control.php";?>
            <div class="content">
                <p class="first">Welcome, <?php echo $_SESSION['nama'];?></p>
                <div class="board">
                    <p>You Can Control Anything in our system with our system</p>
                    <p>Here the link to control our system</p>
                    <div class="info">
                        <p><a href="index.php?p=home" target="_blank">Halaman Utama</a></p>
                    </div>
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