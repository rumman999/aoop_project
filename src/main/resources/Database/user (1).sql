-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Sep 01, 2025 at 05:27 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_user_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `full_name` varchar(127) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone_number` varchar(11) NOT NULL,
  `account_type` varchar(50) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`full_name`, `email`, `password`, `phone_number`, `account_type`, `id`) VALUES
('Torongo Evence Rozario', 'imtorongo@gmail.com', '#23Torongo', '01312025776', 'Admin', 1),
('Muntasir Tofa', 'tofa121@gmail.com', 'T@1234r', '01312523555', 'Recruiter', 2),
('Adnan', 'adnans@yahoo.com', 'B23c23@', '01334567899', 'Jobseeker', 4),
('Dibbo Kumar', 'dk@yahoo.com', 'DK123@k', '01734567896', 'Recruiter', 5),
('Maruf Hossain', 'abc@gmail.com', 'Ma#21', '01324567897', 'Jobseeker', 6),
('', '', '', '', 'Jobseeker', 7),
('Evence Rozario', 'torongoxd@gmail.com', '23torongo', '01618528315', 'Recruiter', 8),
('Rozario', 'torongo121@gmail.com', '12#$ToO', '01720025776', 'Jobseeker', 9),
('Tango Man', 'tango101@yahoo.com', '@23Toro', '01378945612', 'Jobseeker', 10),
('EvenceR', 'imtorono@gmail.com', '#23Torongo', '01312025777', 'Jobseeker', 11),
('Alvinur', 'alvi121@gmail.com', '123@123Aa', '01378945611', 'Admin', 12);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
