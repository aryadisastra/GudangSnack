-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 12, 2019 at 03:54 AM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `familysnack`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` varchar(5) NOT NULL,
  `sisa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `beli`
--

CREATE TABLE `beli` (
  `id_pemasok` varchar(5) DEFAULT NULL,
  `id_barang` varchar(5) NOT NULL,
  `id_petugas` varchar(5) DEFAULT NULL,
  `no_faktur` bigint(20) NOT NULL,
  `nama_barang` varchar(50) DEFAULT NULL,
  `harga_beli` int(11) DEFAULT NULL,
  `harga_jual` int(11) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `satuan` varchar(20) DEFAULT NULL,
  `tgl_masuk` date NOT NULL,
  `expire` date DEFAULT NULL,
  `total` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `jual`
--

CREATE TABLE `jual` (
  `no_faktur` bigint(20) NOT NULL,
  `id_barang` varchar(5) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  `total_harga` int(11) DEFAULT NULL,
  `id_petugas` varchar(5) DEFAULT NULL,
  `id_pelanggan` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(5) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pemasok`
--

CREATE TABLE `pemasok` (
  `id_pemasok` bigint(20) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` text,
  `kontak` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemasok`
--

INSERT INTO `pemasok` (`id_pemasok`, `nama`, `alamat`, `kontak`) VALUES
(6, 'Arya Disastra', 'gsfgdajhkadhkjahs', '1234899'),
(7, 'Bima SaktiRamdani', 'ASNSFJsdg', '98654568'),
(8, 'Bintang Permana Putra', 'asdfjdsfghgfyn', '0945678476'),
(9, 'Trisna Nurdiana', 'fgdthfjkl;', '12345654'),
(10, 'Zahran Difa Vidian', 'wertyiuytre', '12345789');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` varchar(5) NOT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `ttl` date DEFAULT NULL,
  `kontak` varchar(13) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `nama`, `ttl`, `kontak`, `username`, `password`) VALUES
('1', 'arya disastra', '2019-05-20', '34567886', 'arya', 'arya');

-- --------------------------------------------------------

--
-- Table structure for table `tunggakan`
--

CREATE TABLE `tunggakan` (
  `id_tunggakan` bigint(20) NOT NULL,
  `id_pelanggan` varchar(5) DEFAULT NULL,
  `id_pemasok` varchar(5) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `sisa` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`);

--
-- Indexes for table `beli`
--
ALTER TABLE `beli`
  ADD PRIMARY KEY (`no_faktur`,`id_barang`,`tgl_masuk`);

--
-- Indexes for table `jual`
--
ALTER TABLE `jual`
  ADD PRIMARY KEY (`no_faktur`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indexes for table `pemasok`
--
ALTER TABLE `pemasok`
  ADD PRIMARY KEY (`id_pemasok`);

--
-- Indexes for table `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `tunggakan`
--
ALTER TABLE `tunggakan`
  ADD PRIMARY KEY (`id_tunggakan`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pemasok`
--
ALTER TABLE `pemasok`
  MODIFY `id_pemasok` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
