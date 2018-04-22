-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2017 at 05:20 PM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kl_rumah-makan`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_admin`
--

CREATE TABLE `data_admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `bio` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_admin`
--

INSERT INTO `data_admin` (`id`, `username`, `password`, `nama_lengkap`, `bio`) VALUES
(1, 'admin_head', '$2y$10$Ue3XYjJwbwU1Avkn1XRcyeZpRFe0jPF/g2sOsHpZwX9dvSTkN3ZfG', 'M Rizal', 'Seorang Pembelajar');

-- --------------------------------------------------------

--
-- Table structure for table `data_member`
--

CREATE TABLE `data_member` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `ttl` date NOT NULL,
  `domisili` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `kode_pos` int(15) NOT NULL,
  `hp` int(15) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `data_member`
--

INSERT INTO `data_member` (`id`, `username`, `password`, `nama_lengkap`, `ttl`, `domisili`, `alamat`, `kode_pos`, `hp`, `email`) VALUES
(1, 'tetua', '$2y$10$1kjeHcVWHFo9dg7cU1aj3.WZ2K/o9r.UUhr1x0AurMMcQ3BeadDdC', 'Member Pertama', '1998-11-09', 'Yogyakarta', 'Senturan', 984441, 2131315623, 'member_pertama@user.net');

-- --------------------------------------------------------

--
-- Table structure for table `data_pesanan`
--

CREATE TABLE `data_pesanan` (
  `id_pesanan` int(11) NOT NULL,
  `nama_menu` varchar(100) NOT NULL,
  `harga_menu` int(11) NOT NULL,
  `jumlah_order` int(5) NOT NULL,
  `tambahan` text NOT NULL,
  `id_pemesan` int(11) NOT NULL,
  `nama_pemesan` varchar(100) NOT NULL,
  `alamat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `katalog`
--

CREATE TABLE `katalog` (
  `id_katalog` int(11) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `detail` text NOT NULL,
  `harga` int(11) NOT NULL,
  `menu` varchar(32) NOT NULL,
  `gambar` text NOT NULL,
  `tanggal` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `katalog`
--

INSERT INTO `katalog` (`id_katalog`, `nama`, `detail`, `harga`, `menu`, `gambar`, `tanggal`) VALUES
(2, 'Ayam Bakar', 'Ayam Bakar', 15000, 'Makanan', 'Lord-Of-The-Rings-wallpaper.jpg', '2017-11-10 22:59:18'),
(3, 'Makanan Nikmat', 'Ayo dicoba', 123141, 'Minuman', '2.jpg', '2017-11-10 23:03:07'),
(4, 'Makanan Enak nih ', 'ayo dicoba hehehe', 999999999, 'Makanan', 'candice_swanepoel_wild_and_beautiful-wallpaper-2048x1152.jpg', '2017-11-10 23:03:55'),
(5, 'Coklat sadap', 'Mantap nih coklat asli dari sumbernya', 123456, 'Minuman', 'chocolate_wallpaper4788.jpg', '2017-11-10 23:09:08');

-- --------------------------------------------------------

--
-- Table structure for table `kontak`
--

CREATE TABLE `kontak` (
  `id` int(11) NOT NULL,
  `alamat` text NOT NULL,
  `instagram` text NOT NULL,
  `fb` text NOT NULL,
  `twitter` text NOT NULL,
  `email` text NOT NULL,
  `telp` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id_menu` int(11) NOT NULL,
  `nama_menu` varchar(32) NOT NULL,
  `keterangan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_admin`
--
ALTER TABLE `data_admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_member`
--
ALTER TABLE `data_member`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `data_pesanan`
--
ALTER TABLE `data_pesanan`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- Indexes for table `katalog`
--
ALTER TABLE `katalog`
  ADD PRIMARY KEY (`id_katalog`);

--
-- Indexes for table `kontak`
--
ALTER TABLE `kontak`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `data_admin`
--
ALTER TABLE `data_admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `data_member`
--
ALTER TABLE `data_member`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `data_pesanan`
--
ALTER TABLE `data_pesanan`
  MODIFY `id_pesanan` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `katalog`
--
ALTER TABLE `katalog`
  MODIFY `id_katalog` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `kontak`
--
ALTER TABLE `kontak`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id_menu` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
