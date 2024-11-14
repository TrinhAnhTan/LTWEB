-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 14, 2024 at 08:33 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quan_ly_sach`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `author_id` int(11) NOT NULL,
  `author_name` varchar(100) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`author_id`, `author_name`, `date_of_birth`) VALUES
(1, 'Nguyễn Văn A', '1980-05-15'),
(2, 'Trần Thị B', '1975-11-20'),
(3, 'Lê Hữu C', '1990-08-10');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `bookid` int(11) NOT NULL,
  `isbn` int(11) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `price` decimal(6,2) DEFAULT NULL,
  `description` text DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `cover_image` varchar(100) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`bookid`, `isbn`, `title`, `publisher`, `price`, `description`, `publish_date`, `cover_image`, `quantity`) VALUES
(1, 123456, 'Sách 1 của Nguyễn Văn A', 'NXB Giáo dục', 150.00, 'Mô tả sách 1', '2023-01-01', 'cover1.jpg', 10),
(2, 234567, 'Sách 2 của Nguyễn Văn A', 'NXB Lao động', 200.00, 'Mô tả sách 2', '2022-12-01', 'cover2.jpg', 5),
(3, 345678, 'Sách 1 của Trần Thị B', 'NXB Trẻ', 120.00, 'Mô tả sách 3', '2021-10-10', 'cover3.jpg', 8),
(4, 456789, 'Sách 1 của Lê Hữu C', 'NXB Kim Đồng', 180.00, 'Mô tả sách 4', '2020-05-05', 'cover4.jpg', 7);

-- --------------------------------------------------------

--
-- Table structure for table `book_author`
--

CREATE TABLE `book_author` (
  `bookid` int(11) NOT NULL,
  `author_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_author`
--

INSERT INTO `book_author` (`bookid`, `author_id`) VALUES
(1, 1),
(2, 1),
(3, 2),
(4, 3);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `userid` int(11) NOT NULL,
  `bookid` int(11) NOT NULL,
  `rating` tinyint(4) DEFAULT NULL,
  `review_text` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`userid`, `bookid`, `rating`, `review_text`) VALUES
(1, 1, 5, 'Sách rất hay!'),
(1, 2, 3, 'Không tệ nhưng chưa ấn tượng lắm.'),
(1, 4, 4, 'Sách khá ổn.'),
(2, 1, 4, 'Tác phẩm thú vị.'),
(2, 3, 5, 'Tuyệt vời. Nội dung phong phú.');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `fullname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `passwd` varchar(32) DEFAULT NULL,
  `signup_date` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `is_admin` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `email`, `fullname`, `phone`, `passwd`, `signup_date`, `last_login`, `is_admin`) VALUES
(1, 'user1@example.com', 'Người dùng ppppppppp', 123456789, 'password1', '2024-11-14 14:32:08', NULL, b'0'),
(2, 'user2@example.com', 'nguyễn văn bê', 987654321, 'password2', '2024-11-14 14:32:20', NULL, b'0'),
(3, 'minh@gmail.com', 'Minh 333', 123456789, '123456', '2024-11-14 14:32:28', NULL, b'0'),
(4, 'admin@gmail.com', 'Admin b', 123456789, '123456', '2024-11-14 14:32:37', NULL, b'1'),
(8, 'lan@gmail.com', 'lan nguyen', 123456789, '123456', '2024-11-14 14:26:23', '2024-11-14 14:26:23', b'0');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`author_id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`bookid`);

--
-- Indexes for table `book_author`
--
ALTER TABLE `book_author`
  ADD PRIMARY KEY (`bookid`,`author_id`),
  ADD KEY `author_id` (`author_id`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`userid`,`bookid`),
  ADD KEY `bookid` (`bookid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `author_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `bookid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book_author`
--
ALTER TABLE `book_author`
  ADD CONSTRAINT `book_author_ibfk_1` FOREIGN KEY (`bookid`) REFERENCES `books` (`bookid`) ON DELETE CASCADE,
  ADD CONSTRAINT `book_author_ibfk_2` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON DELETE CASCADE;

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `rating_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `rating_ibfk_2` FOREIGN KEY (`bookid`) REFERENCES `books` (`bookid`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
