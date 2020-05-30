-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 04, 2018 at 10:38 AM
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
('1234', 500000.00),
('1235', 50099.00),
('1236', 1000.00);

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
('123', 'TURASH', '1521543212', '1234'),
('124', 'DIPTO', '1765324132', '1235'),
('126', 'TUSHAR', '1678345231', '1236');

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
('17-33333-1', 'Dipta Das', '170000011', 'Manager', 50000.00),
('17-33833-1', 'TURASH', '1773865127', 'ACCOUNTANT', 30000.00),
('17-33839-1', 'TUSHAR', '1765124356', 'CARE TAKER', 150000.00);

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
('123', '6273067', 0),
('124', '1086342', 0),
('126', '9815579', 0),
('17-33333-1', '1236', 1),
('17-33833-1', '3684217', 1),
('17-33839-1', '1361669', 1);

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
('144930', '1234', 'Deposit', 500000.00, '2018-09-04'),
('471467', '1235', 'Deposit', 50099.00, '2018-09-04'),
('652530', '1236', 'Deposit', 1000.00, '2018-09-04');

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
('1234', ''),
('1235', ''),
('1236', '');

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
