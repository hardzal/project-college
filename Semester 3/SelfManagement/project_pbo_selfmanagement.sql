-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2018 at 02:49 AM
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
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `level` enum('ADMIN','MEMBER') NOT NULL,
  `nama` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `username`, `password`, `level`, `nama`, `email`, `created_at`, `updated_at`) VALUES
(1, 'member0', 'password321', 'MEMBER', 'Member Pertama', 'membernol0@gmail.com', '2018-11-16 04:05:09', '2018-11-16 04:05:09'),
(2, 'member1', 'password', 'MEMBER', 'memberbaru@gmail.com', 'Member bar', '2018-11-18 14:55:16', '0000-00-00 00:00:00'),
(3, 'member2', 'password', 'MEMBER', 'member2@gmail.com', 'member kedua', '2018-11-18 14:55:44', '0000-00-00 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `account_managements`
--

CREATE TABLE `account_managements` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `platform` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contactlists`
--

CREATE TABLE `contactlists` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `noHp` varchar(12) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `detail` text,
  `attachement` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notes_categories`
--

CREATE TABLE `notes_categories` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `detail` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `priorities`
--

CREATE TABLE `priorities` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `detail` varchar(50) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `priorities`
--

INSERT INTO `priorities` (`id`, `name`, `detail`, `created_at`, `updated_at`) VALUES
(1, 'High', 'High Priority', '2018-11-21 01:30:00', '2018-11-21 01:30:00'),
(2, 'Medium', 'Medium Priority', '2018-11-21 01:30:00', '2018-11-21 01:30:00'),
(3, 'Low', 'Low Priority', '2018-11-21 01:30:00', '2018-11-21 01:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `schedules`
--

CREATE TABLE `schedules` (
  `id` int(11) NOT NULL,
  `dateend` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedules`
--

INSERT INTO `schedules` (`id`, `dateend`, `created_at`, `updated_at`) VALUES
(1, '2018-11-23 01:25:52', '2018-11-21 01:25:47', '2018-11-21 01:25:47');

-- --------------------------------------------------------

--
-- Table structure for table `statuses`
--

CREATE TABLE `statuses` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `todolists`
--

CREATE TABLE `todolists` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_category` int(11) NOT NULL,
  `id_schedule` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `detail` text,
  `attachement` text,
  `priority` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `todolists`
--

INSERT INTO `todolists` (`id`, `id_user`, `id_category`, `id_schedule`, `title`, `detail`, `attachement`, `priority`, `status`, `created_at`, `updated_at`) VALUES
(1, 1, 1, 1, 'Doing something', 'Something great is coming', NULL, 2, 0, '2018-11-21 01:32:48', '2018-11-21 01:32:48');

-- --------------------------------------------------------

--
-- Table structure for table `todolist_categories`
--

CREATE TABLE `todolist_categories` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `detail` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `todolist_categories`
--

INSERT INTO `todolist_categories` (`id`, `title`, `detail`, `created_at`, `updated_at`) VALUES
(1, 'Work', 'Todolist for working', '2018-11-16 12:38:03', '2018-11-16 12:38:03'),
(2, 'Learn', 'For learning purpose', '2018-11-16 12:38:03', '2018-11-16 12:38:03'),
(3, 'Travel', 'For Travel Purpose', '2018-11-16 12:38:03', '2018-11-16 12:38:03');

-- --------------------------------------------------------

--
-- Table structure for table `todolist_subtasks`
--

CREATE TABLE `todolist_subtasks` (
  `id` int(11) NOT NULL,
  `id_todo` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `detail` text,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `accountmanagement_id` (`id_user`) USING BTREE;

--
-- Indexes for table `contactlists`
--
ALTER TABLE `contactlists`
  ADD PRIMARY KEY (`id`),
  ADD KEY `contactlist_id` (`id_user`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `notes_id` (`id_user`),
  ADD KEY `notescategory_id` (`id_category`);

--
-- Indexes for table `notes_categories`
--
ALTER TABLE `notes_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `priorities`
--
ALTER TABLE `priorities`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `statuses`
--
ALTER TABLE `statuses`
  ADD PRIMARY KEY (`id`),
  ADD KEY `status_id` (`id_user`) USING BTREE;

--
-- Indexes for table `todolists`
--
ALTER TABLE `todolists`
  ADD PRIMARY KEY (`id`),
  ADD KEY `todolist_id` (`id_user`),
  ADD KEY `categorytodo_id` (`id_category`),
  ADD KEY `schedule_id` (`id_schedule`),
  ADD KEY `priority_id` (`priority`);

--
-- Indexes for table `todolist_categories`
--
ALTER TABLE `todolist_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `todolist_subtasks`
--
ALTER TABLE `todolist_subtasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `subtask_id` (`id_todo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

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
-- AUTO_INCREMENT for table `priorities`
--
ALTER TABLE `priorities`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `schedules`
--
ALTER TABLE `schedules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `statuses`
--
ALTER TABLE `statuses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `todolists`
--
ALTER TABLE `todolists`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `todolist_categories`
--
ALTER TABLE `todolist_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `todolist_subtasks`
--
ALTER TABLE `todolist_subtasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account_managements`
--
ALTER TABLE `account_managements`
  ADD CONSTRAINT `accounts` FOREIGN KEY (`id_user`) REFERENCES `accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contactlists`
--
ALTER TABLE `contactlists`
  ADD CONSTRAINT `contactlist_id` FOREIGN KEY (`id_user`) REFERENCES `accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `notes`
--
ALTER TABLE `notes`
  ADD CONSTRAINT `notes_id` FOREIGN KEY (`id_user`) REFERENCES `accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `notescategory_id` FOREIGN KEY (`id_category`) REFERENCES `notes_categories` (`id`);

--
-- Constraints for table `statuses`
--
ALTER TABLE `statuses`
  ADD CONSTRAINT `id_accounts` FOREIGN KEY (`id_user`) REFERENCES `accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `todolists`
--
ALTER TABLE `todolists`
  ADD CONSTRAINT `categorytodo_id` FOREIGN KEY (`id_category`) REFERENCES `todolist_categories` (`id`),
  ADD CONSTRAINT `priority_id` FOREIGN KEY (`priority`) REFERENCES `priorities` (`id`),
  ADD CONSTRAINT `schedule_id` FOREIGN KEY (`id_schedule`) REFERENCES `schedules` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `todolist_id` FOREIGN KEY (`id_user`) REFERENCES `accounts` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `todolist_subtasks`
--
ALTER TABLE `todolist_subtasks`
  ADD CONSTRAINT `subtask_id` FOREIGN KEY (`id_todo`) REFERENCES `todolists` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
