-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2018 at 05:21 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop1e14`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountNumber` varchar(20) NOT NULL,
  `Balance` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountNumber`, `Balance`) VALUES
('1234', 1000.05),
('1235', 2000.00),
('1701034200', 193500.00),
('85558', 99500.00);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `AccountId` varchar(10) NOT NULL,
  `customerName` varchar(20) NOT NULL,
  `phoneNumber` varchar(15) NOT NULL,
  `accountNumber` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`AccountId`, `customerName`, `phoneNumber`, `accountNumber`) VALUES
('17-33872-1', 'Souvik Das', '1781328724', '1701034200'),
('17-33993-1', 'Turash', ' +8801752224442', '85558'),
('17-666-1', 'Shawon Das', ' 001258', '1235'),
('17-888-1', 'Tusar', ' 1782222222', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `AccountId` varchar(20) NOT NULL,
  `empName` varchar(20) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `salary` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`AccountId`, `empName`, `phoneNumber`, `role`, `salary`) VALUES
('17-33333-1', 'Dipta Das', '0170000011', 'Manager', 50000.00),
('17-33833-1', 'Anik Das', ' +880182233665', 'Accountant', 24000.00),
('17-9988-1', 'Rahim Hasan', ' 0178000145', 'Cashear', 150000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `AccountId` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`AccountId`, `password`, `status`) VALUES
('17-33333-1', '1236', 1),
('17-33833-1', '2288391', 1),
('17-33872-1', '1234', 0),
('17-33993-1', '8016451', 0),
('17-666-1', '6746674', 0),
('17-888-1', '1234', 0),
('17-9988-1', '1233', 1);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `transactionId` varchar(20) NOT NULL,
  `accountNumber` varchar(20) NOT NULL,
  `transactionType` varchar(20) NOT NULL,
  `amount` double(10,2) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`transactionId`, `accountNumber`, `transactionType`, `amount`, `date`) VALUES
('1234', '1701034200', 'Deposit', 500.00, '2018-09-04'),
('44238', '1234', 'Send', 500.00, '2018-09-03'),
('455708', '85558', 'Transfer', 500.00, '2018-09-04'),
('766615', '1235', 'Deposit', 500.00, '2018-09-03');

-- --------------------------------------------------------

--
-- Table structure for table `transaction2`
--

CREATE TABLE `transaction2` (
  `accountNumber` varchar(20) NOT NULL,
  `SendTo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction2`
--

INSERT INTO `transaction2` (`accountNumber`, `SendTo`) VALUES
('1234', '1235'),
('1235', ''),
('1701034200', '1235'),
('85558', '1701034200');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountNumber`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`AccountId`),
  ADD UNIQUE KEY `accountNumber` (`accountNumber`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`AccountId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`AccountId`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`transactionId`);

--
-- Indexes for table `transaction2`
--
ALTER TABLE `transaction2`
  ADD PRIMARY KEY (`accountNumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
