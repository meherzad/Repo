-- MySQL dump 10.13  Distrib 5.5.19, for Win32 (x86)
--
-- Host: localhost    Database: repo
-- ------------------------------------------------------
-- Server version	5.5.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `projectbugtrack`
--

DROP TABLE IF EXISTS `projectbugtrack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectbugtrack` (
  `bugId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) DEFAULT NULL,
  `issue` varchar(500) DEFAULT NULL,
  `timeStamp` date DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `bugState` varchar(50) DEFAULT NULL,
  `solution` varchar(500) DEFAULT NULL,
  `fileUrl` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bugId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectbugtrack`
--

LOCK TABLES `projectbugtrack` WRITE;
/*!40000 ALTER TABLE `projectbugtrack` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectbugtrack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectbugtrackcomment`
--

DROP TABLE IF EXISTS `projectbugtrackcomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectbugtrackcomment` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `bugId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `timeSatmp` date DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectbugtrackcomment`
--

LOCK TABLES `projectbugtrackcomment` WRITE;
/*!40000 ALTER TABLE `projectbugtrackcomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectbugtrackcomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectdetail`
--

DROP TABLE IF EXISTS `projectdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectdetail` (
  `projectId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  `jDate` date DEFAULT NULL,
  PRIMARY KEY (`projectId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectdetail`
--

LOCK TABLES `projectdetail` WRITE;
/*!40000 ALTER TABLE `projectdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectdiscussion`
--

DROP TABLE IF EXISTS `projectdiscussion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectdiscussion` (
  `discussionId` int(11) NOT NULL AUTO_INCREMENT,
  `projId` int(11) DEFAULT NULL,
  `discussionHead` varchar(500) DEFAULT NULL,
  `timeStamp` date DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`discussionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectdiscussion`
--

LOCK TABLES `projectdiscussion` WRITE;
/*!40000 ALTER TABLE `projectdiscussion` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectdiscussion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectdiscussioncomment`
--

DROP TABLE IF EXISTS `projectdiscussioncomment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectdiscussioncomment` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `discussionId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `timeSatmp` date DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectdiscussioncomment`
--

LOCK TABLES `projectdiscussioncomment` WRITE;
/*!40000 ALTER TABLE `projectdiscussioncomment` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectdiscussioncomment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectfollower`
--

DROP TABLE IF EXISTS `projectfollower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectfollower` (
  `projectId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  `jDate` date DEFAULT NULL,
  PRIMARY KEY (`projectId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectfollower`
--

LOCK TABLES `projectfollower` WRITE;
/*!40000 ALTER TABLE `projectfollower` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectfollower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectinvitation`
--

DROP TABLE IF EXISTS `projectinvitation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectinvitation` (
  `invitationId` int(11) NOT NULL AUTO_INCREMENT,
  `fromUser` int(11) DEFAULT NULL,
  `toUser` int(11) DEFAULT NULL,
  `projId` int(11) DEFAULT NULL,
  `timeStamp` date DEFAULT NULL,
  `flag` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`invitationId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectinvitation`
--

LOCK TABLES `projectinvitation` WRITE;
/*!40000 ALTER TABLE `projectinvitation` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectinvitation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectmaster`
--

DROP TABLE IF EXISTS `projectmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectmaster` (
  `projId` int(11) NOT NULL AUTO_INCREMENT,
  `projName` varchar(20) DEFAULT NULL,
  `projdesc` varchar(500) DEFAULT NULL,
  `projOwner` int(11) DEFAULT NULL,
  `downloads` int(11) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `projType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`projId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectmaster`
--

LOCK TABLES `projectmaster` WRITE;
/*!40000 ALTER TABLE `projectmaster` DISABLE KEYS */;
INSERT INTO `projectmaster` VALUES (1,'a','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',2,15,55,'sample'),(2,'b','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',2,55,55,'sample'),(3,'b','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',2,5,55,'sample'),(4,'c','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',2,51,55,'sample'),(5,'d','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',2,86,55,'sample');
/*!40000 ALTER TABLE `projectmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectphase`
--

DROP TABLE IF EXISTS `projectphase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectphase` (
  `phaseId` int(11) NOT NULL AUTO_INCREMENT,
  `phaseName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phaseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectphase`
--

LOCK TABLES `projectphase` WRITE;
/*!40000 ALTER TABLE `projectphase` DISABLE KEYS */;
/*!40000 ALTER TABLE `projectphase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projecttask`
--

DROP TABLE IF EXISTS `projecttask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projecttask` (
  `taskId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) DEFAULT NULL,
  `phaseId` int(11) DEFAULT NULL,
  `deadLine` date DEFAULT NULL,
  `taskDescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`taskId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projecttask`
--

LOCK TABLES `projecttask` WRITE;
/*!40000 ALTER TABLE `projecttask` DISABLE KEYS */;
/*!40000 ALTER TABLE `projecttask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projecttaskdetail`
--

DROP TABLE IF EXISTS `projecttaskdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projecttaskdetail` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `taskId` int(11) DEFAULT NULL,
  `subTask` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `timeStamp` date DEFAULT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projecttaskdetail`
--

LOCK TABLES `projecttaskdetail` WRITE;
/*!40000 ALTER TABLE `projecttaskdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `projecttaskdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projecttaskmember`
--

DROP TABLE IF EXISTS `projecttaskmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projecttaskmember` (
  `taskId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`taskId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projecttaskmember`
--

LOCK TABLES `projecttaskmember` WRITE;
/*!40000 ALTER TABLE `projecttaskmember` DISABLE KEYS */;
/*!40000 ALTER TABLE `projecttaskmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userlog`
--

DROP TABLE IF EXISTS `userlog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userlog` (
  `userId` int(11) DEFAULT NULL,
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `timeStamp` date DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userlog`
--

LOCK TABLES `userlog` WRITE;
/*!40000 ALTER TABLE `userlog` DISABLE KEYS */;
/*!40000 ALTER TABLE `userlog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usermaster`
--

DROP TABLE IF EXISTS `usermaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usermaster` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `jDate` date DEFAULT NULL,
  `alternateEmail` varchar(20) DEFAULT NULL,
  `verified` varchar(10) DEFAULT NULL,
  `iUrl` varchar(10) DEFAULT NULL,
  `verificationId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (5,'meherzad@gmail.com','12345','2012-10-23','meherzad@hotmail.com','yes',NULL,'b8c0d7bc879847a44f22faf23f67a04a');
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-25 17:36:46
