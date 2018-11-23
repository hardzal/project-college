-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2018 at 03:01 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project_pbo_selfmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `name`, `email`) VALUES
(1, 'MemberMaster', '1234567', 'membermaster@gmail.com', 'memberBaru');

-- --------------------------------------------------------

--
-- Table structure for table `account_managements`
--

CREATE TABLE `account_managements` (
  `id` int(11) NOT NULL,
  `platform` varchar(100) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contactlists`
--

CREATE TABLE `contactlists` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `no_hp` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `detail` text NOT NULL,
  `attachement` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notes_categories`
--

CREATE TABLE `notes_categories` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `detail` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `todolists`
--

CREATE TABLE `todolists` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `schedule` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `title` varchar(255) NOT NULL,
  `detail` text,
  `attachement` text,
  `priority` varchar(32) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `todolists`
--

INSERT INTO `todolists` (`id`, `id_user`, `id_category`, `schedule`, `title`, `detail`, `attachement`, `priority`, `status`) VALUES
(1, 1, 1, '2018-11-25 14:25:42', 'Hello World', 'Hello world kokoni iru', 'SESUATU.JPG', 'HIGH', 0),
(2, 1, 1, '2018-11-22 15:22:45', 'Belajar Hal Baru', 'Here we go!', 'LINK FILE IMAGE HERE', 'High', 0),
(3, 1, 2, '2019-12-11 17:00:00', 'Belajar sekali', 'Starting!', 'LINK FILE IMAGE HERE', 'Medium', 0),
(4, 1, 1, '2020-12-15 10:00:00', 'Belajar lagi deh mending hehehe', 'Let\'s do it!', 'LINK FILE IMAGE HERE', 'High', 0),
(5, 1, 2, '2018-11-22 15:39:24', 'Hello World hehe', 'Start a new language', 'LINK FILE IMAGE HERE', 'Medium', 0),
(6, 1, 2, '2018-11-22 15:39:17', 'Hello World deh lagi aja', 'Ayo ayo kawan semua', 'LINK FILE IMAGE HERE', 'High', 0),
(7, 1, 2, '2019-04-15 08:00:34', 'Belajar Hal baru kembali', 'Start!', 'LINK FILE IMAGE HERE', 'Medium', 0),
(8, 1, 1, '2018-12-31 09:32:32', 'Belajar CPP', 'Hello World!', 'LINK FILE IMAGE HERE', 'High', 0),
(9, 1, 1, '2018-12-30 05:30:30', 'Belajar Java', 'Hello Starting right now', 'LINK FILE IMAGE HERE', 'High', 0),
(10, 1, 1, '2019-01-01 05:30:30', 'Belajar Scala', 'Belajar sesuatu yang baru', 'LINK FILE IMAGE HERE', 'High', 0),
(11, 1, 1, '2018-11-21 17:00:00', 'Belajar Softskill', 'Baru belajar', 'LINK FILE IMAGE HERE', 'High', 0),
(12, 1, 1, '2019-01-01 17:00:00', 'Freelance', 'Baru saja dimulai', 'LINK FILE IMAGE HERE', 'High', 0),
(13, 1, 1, '2018-12-31 17:00:00', 'Belajar untuk displin', 'Perjalanan baru saja dimulai', 'LINK FILE IMAGE HERE', 'High', 0),
(14, 1, 1, '2018-11-22 17:00:00', 'Belajar jangan pernah menyerah', 'Mari berjuang bersama', 'LINK FILE IMAGE HERE', 'High', 0),
(15, 1, 1, '2018-11-23 17:00:00', 'Pasti bisa', 'Baru dimulai', 'LINK FILE IMAGE HERE', 'High', 0),
(16, 1, 1, '2018-12-11 17:00:00', 'Baru mulai', 'Baru coba', 'LINK FILE IMAGE HERE', 'High', 0),
(17, 1, 1, '2018-12-01 05:21:12', 'Baru lagi', 'coba terus', 'LINK FILE IMAGE HERE', 'High', 0),
(18, 1, 1, '2018-12-11 17:00:00', 'baru coba', 'test', 'LINK FILE IMAGE HERE', 'High', 0),
(19, 1, 1, '2018-12-12 16:00:32', 'ayolah', 'teststs', 'LINK FILE IMAGE HERE', 'High', 0),
(20, 1, 1, '2018-12-12 05:12:12', 'coba lagi', 'teststs', 'LINK FILE IMAGE HERE', 'High', 0),
(21, 1, 1, '2018-12-12 05:12:12', 'berhasil sih tapi', 'tetsts', 'LINK FILE IMAGE HERE', 'High', 0),
(22, 1, 1, '2018-12-12 18:01:01', 'Hello coba lgi', 'tetsts', 'LINK FILE IMAGE HERE', 'High', 0),
(23, 1, 2, '2018-12-13 06:13:13', 'kita coba yuk', 'Testtt', 'LINK FILE IMAGE HERE', 'Medium', 0),
(24, 1, 1, '2018-12-12 17:00:00', 'Semangat try and error', 'tets', 'LINK FILE IMAGE HERE', 'High', 0),
(25, 1, 1, '2018-12-12 17:00:00', 'pernah berhasil', 'test lagi', 'LINK FILE IMAGE HERE', 'High', 0),
(26, 1, 1, '2018-12-01 05:01:01', 'Semangat selalu', 'testt', 'LINK FILE IMAGE HERE', 'High', 0),
(27, 1, 1, '2018-11-30 17:00:00', 'belajar java', 'test', 'LINK FILE IMAGE HERE', 'High', 0),
(28, 1, 1, '2018-11-25 17:00:00', 'belajar java++', 'teetsts', 'LINK FILE IMAGE HERE', 'High', 0),
(29, 1, 1, '2018-11-26 17:00:00', 'Coba terus', 'tetete', 'LINK FILE IMAGE HERE', 'High', 0),
(30, 1, 1, '2018-11-28 17:00:00', 'bismillah', 'teststs', 'LINK FILE IMAGE HERE', 'High', 0);

-- --------------------------------------------------------

--
-- Table structure for table `todolist_categories`
--

CREATE TABLE `todolist_categories` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `detail` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `todolist_categories`
--

INSERT INTO `todolist_categories` (`id`, `title`, `detail`) VALUES
(1, 'Working', 'Working Todo'),
(2, 'Learning', 'Learning Something'),
(3, 'Travelling', 'Travelling again');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `account_managements`
--
ALTER TABLE `account_managements`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `contactlists`
--
ALTER TABLE `contactlists`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notes_categories`
--
ALTER TABLE `notes_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `todolists`
--
ALTER TABLE `todolists`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `todolist_categories`
--
ALTER TABLE `todolist_categories`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `account_managements`
--
ALTER TABLE `account_managements`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contactlists`
--
ALTER TABLE `contactlists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notes_categories`
--
ALTER TABLE `notes_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `todolists`
--
ALTER TABLE `todolists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `todolist_categories`
--
ALTER TABLE `todolist_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
