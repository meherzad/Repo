-- MySQL dump 10.13  Distrib 5.5.24, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: repo
-- ------------------------------------------------------
-- Server version	5.5.24-0ubuntu0.12.04.1

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
-- Table structure for table `PorjectBugTrack`
--

DROP TABLE IF EXISTS `PorjectBugTrack`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PorjectBugTrack` (
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
-- Dumping data for table `PorjectBugTrack`
--

LOCK TABLES `PorjectBugTrack` WRITE;
/*!40000 ALTER TABLE `PorjectBugTrack` DISABLE KEYS */;
/*!40000 ALTER TABLE `PorjectBugTrack` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectBugTrackComment`
--

DROP TABLE IF EXISTS `ProjectBugTrackComment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectBugTrackComment` (
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
-- Dumping data for table `ProjectBugTrackComment`
--

LOCK TABLES `ProjectBugTrackComment` WRITE;
/*!40000 ALTER TABLE `ProjectBugTrackComment` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectBugTrackComment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectDetail`
--

DROP TABLE IF EXISTS `ProjectDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectDetail` (
  `projectId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  `jDate` date DEFAULT NULL,
  PRIMARY KEY (`projectId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectDetail`
--

LOCK TABLES `ProjectDetail` WRITE;
/*!40000 ALTER TABLE `ProjectDetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectDiscussion`
--

DROP TABLE IF EXISTS `ProjectDiscussion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectDiscussion` (
  `discussionId` int(11) NOT NULL AUTO_INCREMENT,
  `projId` int(11) DEFAULT NULL,
  `discussionHead` varchar(500) DEFAULT NULL,
  `timeStamp` date DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`discussionId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectDiscussion`
--

LOCK TABLES `ProjectDiscussion` WRITE;
/*!40000 ALTER TABLE `ProjectDiscussion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectDiscussion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectDiscussionComment`
--

DROP TABLE IF EXISTS `ProjectDiscussionComment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectDiscussionComment` (
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
-- Dumping data for table `ProjectDiscussionComment`
--

LOCK TABLES `ProjectDiscussionComment` WRITE;
/*!40000 ALTER TABLE `ProjectDiscussionComment` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectDiscussionComment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectFollower`
--

DROP TABLE IF EXISTS `ProjectFollower`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectFollower` (
  `projectId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  `jDate` date DEFAULT NULL,
  PRIMARY KEY (`projectId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectFollower`
--

LOCK TABLES `ProjectFollower` WRITE;
/*!40000 ALTER TABLE `ProjectFollower` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectFollower` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectInvitation`
--

DROP TABLE IF EXISTS `ProjectInvitation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectInvitation` (
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
-- Dumping data for table `ProjectInvitation`
--

LOCK TABLES `ProjectInvitation` WRITE;
/*!40000 ALTER TABLE `ProjectInvitation` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectInvitation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectMaster`
--

DROP TABLE IF EXISTS `ProjectMaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectMaster` (
  `projId` int(11) NOT NULL AUTO_INCREMENT,
  `projName` varchar(20) DEFAULT NULL,
  `projDesc` varchar(20) DEFAULT NULL,
  `projOwner` int(11) DEFAULT NULL,
  `downloads` int(11) DEFAULT NULL,
  `likes` int(11) DEFAULT NULL,
  `projType` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`projId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectMaster`
--

LOCK TABLES `ProjectMaster` WRITE;
/*!40000 ALTER TABLE `ProjectMaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectMaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectPhase`
--

DROP TABLE IF EXISTS `ProjectPhase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectPhase` (
  `phaseId` int(11) NOT NULL AUTO_INCREMENT,
  `phaseName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`phaseId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectPhase`
--

LOCK TABLES `ProjectPhase` WRITE;
/*!40000 ALTER TABLE `ProjectPhase` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectPhase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectTask`
--

DROP TABLE IF EXISTS `ProjectTask`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectTask` (
  `taskId` int(11) NOT NULL AUTO_INCREMENT,
  `projectId` int(11) DEFAULT NULL,
  `phaseId` int(11) DEFAULT NULL,
  `deadLine` date DEFAULT NULL,
  `taskDescription` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`taskId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectTask`
--

LOCK TABLES `ProjectTask` WRITE;
/*!40000 ALTER TABLE `ProjectTask` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectTask` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectTaskDetail`
--

DROP TABLE IF EXISTS `ProjectTaskDetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectTaskDetail` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `taskId` int(11) DEFAULT NULL,
  `subTask` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `timeStamp` date DEFAULT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectTaskDetail`
--

LOCK TABLES `ProjectTaskDetail` WRITE;
/*!40000 ALTER TABLE `ProjectTaskDetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectTaskDetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProjectTaskMember`
--

DROP TABLE IF EXISTS `ProjectTaskMember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProjectTaskMember` (
  `taskId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`taskId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProjectTaskMember`
--

LOCK TABLES `ProjectTaskMember` WRITE;
/*!40000 ALTER TABLE `ProjectTaskMember` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProjectTaskMember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserLog`
--

DROP TABLE IF EXISTS `UserLog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserLog` (
  `userId` int(11) DEFAULT NULL,
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `timeStamp` date DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserLog`
--

LOCK TABLES `UserLog` WRITE;
/*!40000 ALTER TABLE `UserLog` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserLog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `UserMaster`
--

DROP TABLE IF EXISTS `UserMaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserMaster` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `jDate` date DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `UserMaster`
--

LOCK TABLES `UserMaster` WRITE;
/*!40000 ALTER TABLE `UserMaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserMaster` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-15  0:55:58
