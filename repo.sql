-- MySQL dump 10.13  Distrib 5.5.28, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: repo
-- ------------------------------------------------------
-- Server version	5.5.28-0ubuntu0.12.04.2

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
-- Table structure for table `licensemaster`
--

DROP TABLE IF EXISTS `licensemaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `licensemaster` (
  `licenseId` int(11) NOT NULL AUTO_INCREMENT,
  `licenseName` varchar(50) DEFAULT NULL,
  `licenseDesc` blob,
  PRIMARY KEY (`licenseId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licensemaster`
--

LOCK TABLES `licensemaster` WRITE;
/*!40000 ALTER TABLE `licensemaster` DISABLE KEYS */;
INSERT INTO `licensemaster` VALUES (1,'Apache License 2.0 (Apache)','       Apache License<br>Version 2.0, January 2004<br>http://www.apache.org/licenses/<br><br>TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION<br><br>1. Definitions.<br><br>\"License\" shall mean the terms and conditions for use, reproduction, and distribution as defined by Sections 1 through 9 of this document.<br><br>\"Licensor\" shall mean the copyright owner or entity authorized by the copyright owner that is granting the License.<br><br>\"Legal Entity\" shall mean the union of the acting entity and all other entities that control, are controlled by, or are under common control with that entity. For the purposes of this definition, \"control\" means (i) the power, direct or indirect, to cause the direction or management of such entity, whether by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstanding shares, or (iii) beneficial ownership of such entity.<br><br>\"You\" (or \"Your\") shall mean an individual or Legal Entity exercising permissions granted by this License.<br><br>\"Source\" form shall mean the preferred form for making modifications, including but not limited to software source code, documentation source, and configuration files.<br><br>\"Object\" form shall mean any form resulting from mechanical transformation or translation of a Source form, including but not limited to compiled object code, generated documentation, and conversions to other media types.<br><br>\"Work\" shall mean the work of authorship, whether in Source or Object form, made available under the License, as indicated by a copyright notice that is included in or attached to the work (an example is provided in the Appendix below).<br><br>\"Derivative Works\" shall mean any work, whether in Source or Object form, that is based on (or derived from) the Work and for which the editorial revisions, annotations, elaborations, or other modifications represent, as a whole, an original work of authorship. For the purposes of this License, Derivative Works shall not include works that remain separable from, or merely link (or bind by name) to the interfaces of, the Work and Derivative Works thereof.<br><br>\"Contribution\" shall mean any work of authorship, including the original version of the Work and any modifications or additions to that Work or Derivative Works thereof, that is intentionally submitted to Licensor for inclusion in the Work by the copyright owner or by an individual or Legal Entity authorized to submit on behalf of the copyright owner. For the purposes of this definition, \"submitted\" means any form of electronic, verbal, or written communication sent to the Licensor or its representatives, including but not limited to communication on electronic mailing lists, source code control systems, and issue tracking systems that are managed by, or on behalf of, the Licensor for the purpose of discussing and improving the Work, but excluding communication that is conspicuously marked or otherwise designated in writing by the copyright owner as \"Not a Contribution.\"<br><br>\"Contributor\" shall mean Licensor and any individual or Legal Entity on behalf of whom a Contribution has been received by Licensor and subsequently incorporated within the Work.<br><br>2. Grant of Copyright License.<br><br>Subject to the terms and conditions of this License, each Contributor hereby grants to You a perpetual, worldwide, non-exclusive, no-charge, royalty-free, irrevocable copyright license to reproduce, prepare Derivative Works of, publicly display, publicly perform, sublicense, and distribute the Work and such Derivative Works in Source or Object form.<br><br>3. Grant of Patent License.<br><br>Subject to the terms and conditions of this License, each Contributor hereby grants to You a perpetual, worldwide, non-exclusive, no-charge, royalty-free, irrevocable (except as stated in this section) patent license to make, have made, use, offer to sell, sell, import, and otherwise transfer the Work, where such license applies only to those patent claims licensable by such Contributor that are necessarily infringed by their Contribution(s) alone or by combination of their Contribution(s) with the Work to which such Contribution(s) was submitted. If You institute patent litigation against any entity (including a cross-claim or counterclaim in a lawsuit) alleging that the Work or a Contribution incorporated within the Work constitutes direct or contributory patent infringement, then any patent licenses granted to You under this License for that Work shall terminate as of the date such litigation is filed.<br><br>4. Redistribution.<br><br>You may reproduce and distribute copies of the Work or Derivative Works thereof in any medium, with or without modifications, and in Source or Object form, provided that You meet the following conditions:<br><br>1. You must give any other recipients of the Work or Derivative Works a copy of this License; and<br><br>2. You must cause any modified files to carry prominent notices stating that You changed the files; and<br><br>3. You must retain, in the Source form of any Derivative Works that You distribute, all copyright, patent, trademark, and attribution notices from the Source form of the Work, excluding those notices that do not pertain to any part of the Derivative Works; and<br><br>4. If the Work includes a \"NOTICE\" text file as part of its distribution, then any Derivative Works that You distribute must include a readable copy of the attribution notices contained within such NOTICE file, excluding those notices that do not pertain to any part of the Derivative Works, in at least one of the following places: within a NOTICE text file distributed as part of the Derivative Works; within the Source form or documentation, if provided along with the Derivative Works; or, within a display generated by the Derivative Works, if and wherever such third-party notices normally appear. The contents of the NOTICE file are for informational purposes only and do not modify the License. You may add Your own attribution notices within Derivative Works that You distribute, alongside or as an addendum to the NOTICE text from the Work, provided that such additional attribution notices cannot be construed as modifying the License.<br><br>You may add Your own copyright statement to Your modifications and may provide additional or different license terms and conditions for use, reproduction, or distribution of Your modifications, or for any such Derivative Works as a whole, provided Your use, reproduction, and distribution of the Work otherwise complies with the conditions stated in this License.<br><br>5. Submission of Contributions.<br><br>Unless You explicitly state otherwise, any Contribution intentionally submitted for inclusion in the Work by You to the Licensor shall be under the terms and conditions of this License, without any additional terms or conditions. Notwithstanding the above, nothing herein shall supersede or modify the terms of any separate license agreement you may have executed with Licensor regarding such Contributions.<br><br>6. Trademarks.<br><br>This License does not grant permission to use the trade names, trademarks, service marks, or product names of the Licensor, except as required for reasonable and customary use in describing the origin of the Work and reproducing the content of the NOTICE file.<br><br>7. Disclaimer of Warranty.<br><br>Unless required by applicable law or agreed to in writing, Licensor provides the Work (and each Contributor provides its Contributions) on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied, including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. You are solely responsible for determining the appropriateness of using or redistributing the Work and assume any risks associated with Your exercise of permissions under this License.<br><br>8. Limitation of Liability.<br><br>In no event and under no legal theory, whether in tort (including negligence), contract, or otherwise, unless required by applicable law (such as deliberate and grossly negligent acts) or agreed to in writing, shall any Contributor be liable to You for damages, including any direct, indirect, special, incidental, or consequential damages of any character arising as a result of this License or out of the use or inability to use the Work (including but not limited to damages for loss of goodwill, work stoppage, computer failure or malfunction, or any and all other commercial damages or losses), even if such Contributor has been advised of the possibility of such damages.<br><br>9. Accepting Warranty or Additional Liability.<br><br>While redistributing the Work or Derivative Works thereof, You may choose to offer, and charge a fee for, acceptance of support, warranty, indemnity, or other liability obligations and/or rights consistent with this License. However, in accepting such obligations, You may act only on Your own behalf and on Your sole responsibility, not on behalf of any other Contributor, and only if You agree to indemnify, defend, and hold each Contributor harmless for any liability incurred by, or claims asserted against, such Contributor by reason of your accepting any such warranty or additional liability.             '),(2,'Apache','       Apache License<br>Version 2.0, January 2004<br>http://www.apache.org/licenses/<br><br>TERMS AND CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION<br><br>1. Definitions.<br><br>\"License\" shall mean the terms and conditions for use, reproduction, and distribution as defined by Sections 1 through 9 of this document.<br><br>\"Licensor\" shall mean the copyright owner or entity authorized by the copyright owner that is granting the License.<br><br>\"Legal Entity\" shall mean the union of the acting entity and all other entities that control, are controlled by, or are under common control with that entity. For the purposes of this definition, \"control\" means (i) the power, direct or indirect, to cause the direction or management of such entity, whether by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstanding shares, or (iii) beneficial ownership of such entity.<br><br>\"You\" (or \"Your\") shall mean an individual or Legal Entity exercising permissions granted by this License.<br><br>\"Source\" form shall mean the preferred form for making modifications, including but not limited to software source code, documentation source, and configuration files.<br><br>\"Object\" form shall mean any form resulting from mechanical transformation or translation of a Source form, including but not limited to compiled object code, generated documentation, and conversions to other media types.<br><br>\"Work\" shall mean the work of authorship, whether in Source or Object form, made available under the License, as indicated by a copyright notice that is included in or attached to the work (an example is provided in the Appendix below).<br><br>\"Derivative Works\" shall mean any work, whether in Source or Object form, that is based on (or derived from) the Work and for which the editorial revisions, annotations, elaborations, or other modifications represent, as a whole, an original work of authorship. For the purposes of this License, Derivative Works shall not include works that remain separable from, or merely link (or bind by name) to the interfaces of, the Work and Derivative Works thereof.<br><br>\"Contribution\" shall mean any work of authorship, including the original version of the Work and any modifications or additions to that Work or Derivative Works thereof, that is intentionally submitted to Licensor for inclusion in the Work by the copyright owner or by an individual or Legal Entity authorized to submit on behalf of the copyright owner. For the purposes of this definition, \"submitted\" means any form of electronic, verbal, or written communication sent to the Licensor or its representatives, including but not limited to communication on electronic mailing lists, source code control systems, and issue tracking systems that are managed by, or on behalf of, the Licensor for the purpose of discussing and improving the Work, but excluding communication that is conspicuously marked or otherwise designated in writing by the copyright owner as \"Not a Contribution.\"<br><br>\"Contributor\" shall mean Licensor and any individual or Legal Entity on behalf of whom a Contribution has been received by Licensor and subsequently incorporated within the Work.<br><br>2. Grant of Copyright License.<br><br>Subject to the terms and conditions of this License, each Contributor hereby grants to You a perpetual, worldwide, non-exclusive, no-charge, royalty-free, irrevocable copyright license to reproduce, prepare Derivative Works of, publicly display, publicly perform, sublicense, and distribute the Work and such Derivative Works in Source or Object form.<br><br>3. Grant of Patent License.<br><br>Subject to the terms and conditions of this License, each Contributor hereby grants to You a perpetual, worldwide, non-exclusive, no-charge, royalty-free, irrevocable (except as stated in this section) patent license to make, have made, use, offer to sell, sell, import, and otherwise transfer the Work, where such license applies only to those patent claims licensable by such Contributor that are necessarily infringed by their Contribution(s) alone or by combination of their Contribution(s) with the Work to which such Contribution(s) was submitted. If You institute patent litigation against any entity (including a cross-claim or counterclaim in a lawsuit) alleging that the Work or a Contribution incorporated within the Work constitutes direct or contributory patent infringement, then any patent licenses granted to You under this License for that Work shall terminate as of the date such litigation is filed.<br><br>4. Redistribution.<br><br>You may reproduce and distribute copies of the Work or Derivative Works thereof in any medium, with or without modifications, and in Source or Object form, provided that You meet the following conditions:<br><br>1. You must give any other recipients of the Work or Derivative Works a copy of this License; and<br><br>2. You must cause any modified files to carry prominent notices stating that You changed the files; and<br><br>3. You must retain, in the Source form of any Derivative Works that You distribute, all copyright, patent, trademark, and attribution notices from the Source form of the Work, excluding those notices that do not pertain to any part of the Derivative Works; and<br><br>4. If the Work includes a \"NOTICE\" text file as part of its distribution, then any Derivative Works that You distribute must include a readable copy of the attribution notices contained within such NOTICE file, excluding those notices that do not pertain to any part of the Derivative Works, in at least one of the following places: within a NOTICE text file distributed as part of the Derivative Works; within the Source form or documentation, if provided along with the Derivative Works; or, within a display generated by the Derivative Works, if and wherever such third-party notices normally appear. The contents of the NOTICE file are for informational purposes only and do not modify the License. You may add Your own attribution notices within Derivative Works that You distribute, alongside or as an addendum to the NOTICE text from the Work, provided that such additional attribution notices cannot be construed as modifying the License.<br><br>You may add Your own copyright statement to Your modifications and may provide additional or different license terms and conditions for use, reproduction, or distribution of Your modifications, or for any such Derivative Works as a whole, provided Your use, reproduction, and distribution of the Work otherwise complies with the conditions stated in this License.<br><br>5. Submission of Contributions.<br><br>Unless You explicitly state otherwise, any Contribution intentionally submitted for inclusion in the Work by You to the Licensor shall be under the terms and conditions of this License, without any additional terms or conditions. Notwithstanding the above, nothing herein shall supersede or modify the terms of any separate license agreement you may have executed with Licensor regarding such Contributions.<br><br>6. Trademarks.<br><br>This License does not grant permission to use the trade names, trademarks, service marks, or product names of the Licensor, except as required for reasonable and customary use in describing the origin of the Work and reproducing the content of the NOTICE file.<br><br>7. Disclaimer of Warranty.<br><br>Unless required by applicable law or agreed to in writing, Licensor provides the Work (and each Contributor provides its Contributions) on an \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied, including, without limitation, any warranties or conditions of TITLE, NON-INFRINGEMENT, MERCHANTABILITY, or FITNESS FOR A PARTICULAR PURPOSE. You are solely responsible for determining the appropriateness of using or redistributing the Work and assume any risks associated with Your exercise of permissions under this License.<br><br>8. Limitation of Liability.<br><br>In no event and under no legal theory, whether in tort (including negligence), contract, or otherwise, unless required by applicable law (such as deliberate and grossly negligent acts) or agreed to in writing, shall any Contributor be liable to You for damages, including any direct, indirect, special, incidental, or consequential damages of any character arising as a result of this License or out of the use or inability to use the Work (including but not limited to damages for loss of goodwill, work stoppage, computer failure or malfunction, or any and all other commercial damages or losses), even if such Contributor has been advised of the possibility of such damages.<br><br>9. Accepting Warranty or Additional Liability.<br><br>While redistributing the Work or Derivative Works thereof, You may choose to offer, and charge a fee for, acceptance of support, warranty, indemnity, or other liability obligations and/or rights consistent with this License. However, in accepting such obligations, You may act only on Your own behalf and on Your sole responsibility, not on behalf of any other Contributor, and only if You agree to indemnify, defend, and hold each Contributor harmless for any liability incurred by, or claims asserted against, such Contributor by reason of your accepting any such warranty or additional liability.             '),(3,'New BSD License (BSD)','Copyright (c) <span class=\"LicenseFieldValue\"><span class=\"Disabled\">(YEAR)</span></span>, <span class=\"LicenseFieldValue\"><span class=\"Disabled\">(OWNER)</span></span><br>All rights reserved.<br><br>Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:<br><br>* Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.<br><br>* Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.<br><br>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.       '),(4,'Eclipse Public License (EPL)','THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS ECLIPSE PUBLIC LICENSE (\"AGREEMENT\"). ANY USE, REPRODUCTION OR DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT\'S ACCEPTANCE OF THIS AGREEMENT.<br><br>1. DEFINITIONS<br><br>\"Contribution\" means:<br><br>a) in the case of the initial Contributor, the initial code and documentation distributed under this Agreement, and<br><br>b) in the case of each subsequent Contributor:<br><br>i) changes to the Program, and<br><br>ii) additions to the Program; <br><br>where such changes and/or additions to the Program originate from and are distributed by that particular Contributor. A Contribution \'originates\' from a Contributor if it was added to the Program by such Contributor itself or anyone acting on such Contributor\'s behalf. Contributions do not include additions to the Program which: (i) are separate modules of software distributed in conjunction with the Program under their own license agreement, and (ii) are not derivative works of the Program.<br><br>\"Contributor\" means any person or entity that distributes the Program.<br><br>\"Licensed Patents \" mean patent claims licensable by a Contributor which are necessarily infringed by the use or sale of its Contribution alone or when combined with the Program.<br><br>\"Program\" means the Contributions distributed in accordance with this Agreement.<br><br>\"Recipient\" means anyone who receives the Program under this Agreement, including all Contributors.<br><br>2. GRANT OF RIGHTS<br><br>a) Subject to the terms of this Agreement, each Contributor hereby grants Recipient a non-exclusive, worldwide, royalty-free copyright license to reproduce, prepare derivative works of, publicly display, publicly perform, distribute and sublicense the Contribution of such Contributor, if any, and such derivative works, in source code and object code form.<br><br>b) Subject to the terms of this Agreement, each Contributor hereby grants Recipient a non-exclusive, worldwide, royalty-free patent license under Licensed Patents to make, use, sell, offer to sell, import and otherwise transfer the Contribution of such Contributor, if any, in source code and object code form. This patent license shall apply to the combination of the Contribution and the Program if, at the time the Contribution is added by the Contributor, such addition of the Contribution causes such combination to be covered by the Licensed Patents. The patent license shall not apply to any other combinations which include the Contribution. No hardware per se is licensed hereunder.<br><br>c) Recipient understands that although each Contributor grants the licenses to its Contributions set forth herein, no assurances are provided by any Contributor that the Program does not infringe the patent or other intellectual property rights of any other entity. Each Contributor disclaims any liability to Recipient for claims brought by any other entity based on infringement of intellectual property rights or otherwise. As a condition to exercising the rights and licenses granted hereunder, each Recipient hereby assumes sole responsibility to secure any other intellectual property rights needed, if any. For example, if a third party patent license is required to allow Recipient to distribute the Program, it is Recipient\'s responsibility to acquire that license before distributing the Program.<br><br>d) Each Contributor represents that to its knowledge it has sufficient copyright rights in its Contribution, if any, to grant the copyright license set forth in this Agreement.<br><br>3. REQUIREMENTS<br><br>A Contributor may choose to distribute the Program in object code form under its own license agreement, provided that:<br><br>a) it complies with the terms and conditions of this Agreement; and<br><br>b) its license agreement:<br><br>i) effectively disclaims on behalf of all Contributors all warranties and conditions, express and implied, including warranties or conditions of title and non-infringement, and implied warranties or conditions of merchantability and fitness for a particular purpose;<br><br>ii) effectively excludes on behalf of all Contributors all liability for damages, including direct, indirect, special, incidental and consequential damages, such as lost profits;<br><br>iii) states that any provisions which differ from this Agreement are offered by that Contributor alone and not by any other party; and<br><br>iv) states that source code for the Program is available from such Contributor, and informs licensees how to obtain it in a reasonable manner on or through a medium customarily used for software exchange. <br><br>When the Program is made available in source code form:<br><br>a) it must be made available under this Agreement; and<br><br>b) a copy of this Agreement must be included with each copy of the Program. <br><br>Contributors may not remove or alter any copyright notices contained within the Program.<br><br>Each Contributor must identify itself as the originator of its Contribution, if any, in a manner that reasonably allows subsequent Recipients to identify the originator of the Contribution.<br><br>4. COMMERCIAL DISTRIBUTION<br><br>Commercial distributors of software may accept certain responsibilities with respect to end users, business partners and the like. While this license is intended to facilitate the commercial use of the Program, the Contributor who includes the Program in a commercial product offering should do so in a manner which does not create potential liability for other Contributors. Therefore, if a Contributor includes the Program in a commercial product offering, such Contributor (\"Commercial Contributor\") hereby agrees to defend and indemnify every other Contributor (\"Indemnified Contributor\") against any losses, damages and costs (collectively \"Losses\") arising from claims, lawsuits and other legal actions brought by a third party against the Indemnified Contributor to the extent caused by the acts or omissions of such Commercial Contributor in connection with its distribution of the Program in a commercial product offering. The obligations in this section do not apply to any claims or Losses relating to any actual or alleged intellectual property infringement. In order to qualify, an Indemnified Contributor must: a) promptly notify the Commercial Contributor in writing of such claim, and b) allow the Commercial Contributor to control, and cooperate with the Commercial Contributor in, the defense and any related settlement negotiations. The Indemnified Contributor may participate in any such claim at its own expense.<br><br>For example, a Contributor might include the Program in a commercial product offering, Product X. That Contributor is then a Commercial Contributor. If that Commercial Contributor then makes performance claims, or offers warranties related to Product X, those performance claims and warranties are such Commercial Contributor\'s responsibility alone. Under this section, the Commercial Contributor would have to defend claims against the other Contributors related to those performance claims and warranties, and if a court requires any other Contributor to pay any damages as a result, the Commercial Contributor must pay those damages.<br><br>5. NO WARRANTY<br><br>EXCEPT AS EXPRESSLY SET FORTH IN THIS AGREEMENT, THE PROGRAM IS PROVIDED ON AN \"AS IS\" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, EITHER EXPRESS OR IMPLIED INCLUDING, WITHOUT LIMITATION, ANY WARRANTIES OR CONDITIONS OF TITLE, NON-INFRINGEMENT, MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Each Recipient is solely responsible for determining the appropriateness of using and distributing the Program and assumes all risks associated with its exercise of rights under this Agreement , including but not limited to the risks and costs of program errors, compliance with applicable laws, damage to or loss of data, programs or equipment, and unavailability or interruption of operations.<br><br>6. DISCLAIMER OF LIABILITY<br><br>EXCEPT AS EXPRESSLY SET FORTH IN THIS AGREEMENT, NEITHER RECIPIENT NOR ANY CONTRIBUTORS SHALL HAVE ANY LIABILITY FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING WITHOUT LIMITATION LOST PROFITS), HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OR DISTRIBUTION OF THE PROGRAM OR THE EXERCISE OF ANY RIGHTS GRANTED HEREUNDER, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.<br><br>7. GENERAL<br><br>If any provision of this Agreement is invalid or unenforceable under applicable law, it shall not affect the validity or enforceability of the remainder of the terms of this Agreement, and without further action by the parties hereto, such provision shall be reformed to the minimum extent necessary to make such provision valid and enforceable.<br><br>If Recipient institutes patent litigation against any entity (including a cross-claim or counterclaim in a lawsuit) alleging that the Program itself (excluding combinations of the Program with other software or hardware) infringes such Recipient\'s patent(s), then such Recipient\'s rights granted under Section 2(b) shall terminate as of the date such litigation is filed.<br><br>All Recipient\'s rights under this Agreement shall terminate if it fails to comply with any of the material terms or conditions of this Agreement and does not cure such failure in a reasonable period of time after becoming aware of such noncompliance. If all Recipient\'s rights under this Agreement terminate, Recipient agrees to cease use and distribution of the Program as soon as reasonably practicable. However, Recipient\'s obligations under this Agreement and any licenses granted by Recipient relating to the Program shall continue and survive.<br><br>Everyone is permitted to copy and distribute copies of this Agreement, but in order to avoid inconsistency the Agreement is copyrighted and may only be modified in the following manner. The Agreement Steward reserves the right to publish new versions (including revisions) of this Agreement from time to time. No one other than the Agreement Steward has the right to modify this Agreement. The Eclipse Foundation is the initial Agreement Steward. The Eclipse Foundation may assign the responsibility to serve as the Agreement Steward to a suitable separate entity. Each new version of the Agreement will be given a distinguishing version number. The Program (including Contributions) may always be distributed subject to the version of the Agreement under which it was received. In addition, after a new version of the Agreement is published, Contributor may elect to distribute the Program (including its Contributions) under the new version. Except as expressly stated in Sections 2(a) and 2(b) above, Recipient receives no rights or licenses to the intellectual property of any Contributor under this Agreement, whether expressly, by implication, estoppel or otherwise. All rights in the Program not expressly granted under this Agreement are reserved.<br><br>This Agreement is governed by the laws of the State of New York and the intellectual property laws of the United States of America. No party to this Agreement will bring a legal action under this Agreement more than one year after the cause of action arose. Each party waives its rights to a jury trial in any resulting litigation.                 '),(5,'Common Development and Distribution License (CDDL)','1. Definitions.<br><br>1.1. Contributor means each individual or entity that creates or contributes to the creation of Modifications.<br><br>1.2. Contributor Version means the combination of the Original Software, prior Modifications used by a Contributor (if any), and the Modifications made by that particular Contributor.<br><br>1.3. Covered Software means (a) the Original Software, or (b) Modifications, or (c) the combination of files containing Original Software with files containing Modifications, in each case including portions thereof.<br><br>1.4. Executable means the Covered Software in any form other than Source Code.<br><br>1.5. Initial Developer means the individual or entity that first makes Original Software available under this License.<br><br>1.6. Larger Work means a work which combines Covered Software or portions thereof with code not governed by the terms of this License.<br><br>1.7. License means this document.<br><br>1.8. Licensable means having the right to grant, to the maximum extent possible, whether at the time of the initial grant or subsequently acquired, any and all of the rights conveyed herein.<br><br>1.9. Modifications means the Source Code and Executable form of any of the following:<br><br>A. Any file that results from an addition to, deletion from or modification of the contents of a file containing Original Software or previous Modifications;<br><br>B. Any new file that contains any part of the Original Software or previous Modification; or<br><br>C. Any new file that is contributed or otherwise made available under the terms of this License.<br><br>1.10. Original Software means the Source Code and Executable form of computer software code that is originally released under this License.<br><br>1.11. Patent Claims means any patent claim(s), now owned or hereafter acquired, including without limitation, method, process, and apparatus claims, in any patent Licensable by grantor.<br><br>1.12. Source Code means (a) the common form of computer software code in which modifications are made and (b) associated documentation included in or with such code.<br><br>1.13. You (or Your) means an individual or a legal entity exercising rights under, and complying with all of the terms of, this License. For legal entities, You includes any entity which controls, is controlled by, or is under common control with You. For purposes of this definition, control means (a) the power, direct or indirect, to cause the direction or management of such entity, whether by contract or otherwise, or (b) ownership of more than fifty percent (50%) of the outstanding shares or beneficial ownership of such entity.<br><br>2. License Grants.<br><br>2.1. The Initial Developer Grant.<br><br>Conditioned upon Your compliance with Section 3.1 below and subject to third party intellectual property claims, the Initial Developer hereby grants You a world-wide, royalty-free, non-exclusive license:<br><br>(a) under intellectual property rights (other than patent or trademark) Licensable by Initial Developer, to use, reproduce, modify, display, perform, sublicense and distribute the Original Software (or portions thereof), with or without Modifications, and/or as part of a Larger Work; and<br><br>(b) under Patent Claims infringed by the making, using or selling of Original Software, to make, have made, use, practice, sell, and offer for sale, and/or otherwise dispose of the Original Software (or portions thereof).<br><br>(c) The licenses granted in Sections 2.1(a) and (b) are effective on the date Initial Developer first distributes or otherwise makes the Original Software available to a third party under the terms of this License.<br><br>(d) Notwithstanding Section 2.1(b) above, no patent license is granted: (1) for code that You delete from the Original Software, or (2) for infringements caused by: (i) the modification of the Original Software, or (ii) the combination of the Original Software with other software or devices.<br><br>2.2. Contributor Grant.<br><br>Conditioned upon Your compliance with Section 3.1 below and subject to third party intellectual property claims, each Contributor hereby grants You a world-wide, royalty-free, non-exclusive license:<br><br>(a) under intellectual property rights (other than patent or trademark) Licensable by Contributor to use, reproduce, modify, display, perform, sublicense and distribute the Modifications created by such Contributor (or portions thereof), either on an unmodified basis, with other Modifications, as Covered Software and/or as part of a Larger Work; and<br><br>(b) under Patent Claims infringed by the making, using, or selling of Modifications made by that Contributor either alone and/or in combination with its Contributor Version (or portions of such combination), to make, use, sell, offer for sale, have made, and/or otherwise dispose of: (1) Modifications made by that Contributor (or portions thereof); and (2) the combination of Modifications made by that Contributor with its Contributor Version (or portions of such combination).<br><br>(c) The licenses granted in Sections 2.2(a) and 2.2(b) are effective on the date Contributor first distributes or otherwise makes the Modifications available to a third party.<br><br>(d) Notwithstanding Section 2.2(b) above, no patent license is granted: (1) for any code that Contributor has deleted from the Contributor Version; (2) for infringements caused by: (i) third party modifications of Contributor Version, or (ii) the combination of Modifications made by that Contributor with other software (except as part of the Contributor Version) or other devices; or (3) under Patent Claims infringed by Covered Software in the absence of Modifications made by that Contributor.<br><br>3. Distribution Obligations.<br><br>3.1. Availability of Source Code.<br><br>Any Covered Software that You distribute or otherwise make available in Executable form must also be made available in Source Code form and that Source Code form must be distributed only under the terms of this License. You must include a copy of this License with every copy of the Source Code form of the Covered Software You distribute or otherwise make available. You must inform recipients of any such Covered Software in Executable form as to how they can obtain such Covered Software in Source Code form in a reasonable manner on or through a medium customarily used for software exchange.<br><br>3.2. Modifications.<br><br>The Modifications that You create or to which You contribute are governed by the terms of this License. You represent that You believe Your Modifications are Your original creation(s) and/or You have sufficient rights to grant the rights conveyed by this License.<br><br>3.3. Required Notices.<br><br>You must include a notice in each of Your Modifications that identifies You as the Contributor of the Modification. You may not remove or alter any copyright, patent or trademark notices contained within the Covered Software, or any notices of licensing or any descriptive text giving attribution to any Contributor or the Initial Developer.<br><br>3.4. Application of Additional Terms.<br><br>You may not offer or impose any terms on any Covered Software in Source Code form that alters or restricts the applicable version of this License or the recipients rights hereunder. You may choose to offer, and to charge a fee for, warranty, support, indemnity or liability obligations to one or more recipients of Covered Software. However, you may do so only on Your own behalf, and not on behalf of the Initial Developer or any Contributor. You must make it absolutely clear that any such warranty, support, indemnity or liability obligation is offered by You alone, and You hereby agree to indemnify the Initial Developer and every Contributor for any liability incurred by the Initial Developer or such Contributor as a result of warranty, support, indemnity or liability terms You offer.<br><br>3.5. Distribution of Executable Versions.<br><br>You may distribute the Executable form of the Covered Software under the terms of this License or under the terms of a license of Your choice, which may contain terms different from this License, provided that You are in compliance with the terms of this License and that the license for the Executable form does not attempt to limit or alter the recipients rights in the Source Code form from the rights set forth in this License. If You distribute the Covered Software in Executable form under a different license, You must make it absolutely clear that any terms which differ from this License are offered by You alone, not by the Initial Developer or Contributor. You hereby agree to indemnify the Initial Developer and every Contributor for any liability incurred by the Initial Developer or such Contributor as a result of any such terms You offer.<br><br>3.6. Larger Works.<br><br>You may create a Larger Work by combining Covered Software with other code not governed by the terms of this License and distribute the Larger Work as a single product. In such a case, You must make sure the requirements of this License are fulfilled for the Covered Software.<br><br>4. Versions of the License.<br><br>4.1. New Versions.<br><br>Sun Microsystems, Inc. is the initial license steward and may publish revised and/or new versions of this License from time to time. Each version will be given a distinguishing version number. Except as provided in Section 4.3, no one other than the license steward has the right to modify this License.<br><br>4.2. Effect of New Versions.<br><br>You may always continue to use, distribute or otherwise make the Covered Software available under the terms of the version of the License under which You originally received the Covered Software. If the Initial Developer includes a notice in the Original Software prohibiting it from being distributed or otherwise made available under any subsequent version of the License, You must distribute and make the Covered Software available under the terms of the version of the License under which You originally received the Covered Software. Otherwise, You may also choose to use, distribute or otherwise make the Covered Software available under the terms of any subsequent version of the License published by the license steward.<br><br>4.3. Modified Versions.<br><br>When You are an Initial Developer and You want to create a new license for Your Original Software, You may create and use a modified version of this License if You: (a) rename the license and remove any references to the name of the license steward (except to note that the license differs from this License); and (b) otherwise make it clear that the license contains terms which differ from this License.<br><br>5. DISCLAIMER OF WARRANTY.<br><br>COVERED SOFTWARE IS PROVIDED UNDER THIS LICENSE ON AN AS IS BASIS, WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, WITHOUT LIMITATION, WARRANTIES THAT THE COVERED SOFTWARE IS FREE OF DEFECTS, MERCHANTABLE, FIT FOR A PARTICULAR PURPOSE OR NON-INFRINGING. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE COVERED SOFTWARE IS WITH YOU. SHOULD ANY COVERED SOFTWARE PROVE DEFECTIVE IN ANY RESPECT, YOU (NOT THE INITIAL DEVELOPER OR ANY OTHER CONTRIBUTOR) ASSUME THE COST OF ANY NECESSARY SERVICING, REPAIR OR CORRECTION. THIS DISCLAIMER OF WARRANTY CONSTITUTES AN ESSENTIAL PART OF THIS LICENSE. NO USE OF ANY COVERED SOFTWARE IS AUTHORIZED HEREUNDER EXCEPT UNDER THIS DISCLAIMER.<br><br>6. TERMINATION.<br><br>6.1. This License and the rights granted hereunder will terminate automatically if You fail to comply with terms herein and fail to cure such breach within 30 days of becoming aware of the breach. Provisions which, by their nature, must remain in effect beyond the termination of this License shall survive.<br><br>6.2. If You assert a patent infringement claim (excluding declaratory judgment actions) against Initial Developer or a Contributor (the Initial Developer or Contributor against whom You assert such claim is referred to as Participant) alleging that the Participant Software (meaning the Contributor Version where the Participant is a Contributor or the Original Software where the Participant is the Initial Developer) directly or indirectly infringes any patent, then any and all rights granted directly or indirectly to You by such Participant, the Initial Developer (if the Initial Developer is not the Participant) and all Contributors under Sections 2.1 and/or 2.2 of this License shall, upon 60 days notice from Participant terminate prospectively and automatically at the expiration of such 60 day notice period, unless if within such 60 day period You withdraw Your claim with respect to the Participant Software against such Participant either unilaterally or pursuant to a written agreement with Participant.<br><br>6.3. In the event of termination under Sections 6.1 or 6.2 above, all end user licenses that have been validly granted by You or any distributor hereunder prior to termination (excluding licenses granted to You by any distributor) shall survive termination.<br><br>7. LIMITATION OF LIABILITY.<br><br>UNDER NO CIRCUMSTANCES AND UNDER NO LEGAL THEORY, WHETHER TORT (INCLUDING NEGLIGENCE), CONTRACT, OR OTHERWISE, SHALL YOU, THE INITIAL DEVELOPER, ANY OTHER CONTRIBUTOR, OR ANY DISTRIBUTOR OF COVERED SOFTWARE, OR ANY SUPPLIER OF ANY OF SUCH PARTIES, BE LIABLE TO ANY PERSON FOR ANY INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES OF ANY CHARACTER INCLUDING, WITHOUT LIMITATION, DAMAGES FOR LOST PROFITS, LOSS OF GOODWILL, WORK STOPPAGE, COMPUTER FAILURE OR MALFUNCTION, OR ANY AND ALL OTHER COMMERCIAL DAMAGES OR LOSSES, EVEN IF SUCH PARTY SHALL HAVE BEEN INFORMED OF THE POSSIBILITY OF SUCH DAMAGES. THIS LIMITATION OF LIABILITY SHALL NOT APPLY TO LIABILITY FOR DEATH OR PERSONAL INJURY RESULTING FROM SUCH PARTYS NEGLIGENCE TO THE EXTENT APPLICABLE LAW PROHIBITS SUCH LIMITATION. SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OR LIMITATION OF INCIDENTAL OR CONSEQUENTIAL DAMAGES, SO THIS EXCLUSION AND LIMITATION MAY NOT APPLY TO YOU.<br><br>8. U.S. GOVERNMENT END USERS.<br><br>The Covered Software is a commercial item, as that term is defined in 48 C.F.R. 2.101 (Oct. 1995), consisting of commercial computer software (as that term is defined at 48 C.F.R. 252.227-7014(a)(1)) and commercial computer software documentation as such terms are used in 48 C.F.R. 12.212 (Sept. 1995). Consistent with 48 C.F.R. 12.212 and 48 C.F.R. 227.7202-1 through 227.7202-4 (June 1995), all U.S. Government End Users acquire Covered Software with only those rights set forth herein. This U.S. Government Rights clause is in lieu of, and supersedes, any other FAR, DFAR, or other clause or provision that addresses Government rights in computer software under this License.<br><br>9. MISCELLANEOUS.<br><br>This License represents the complete agreement concerning subject matter hereof. If any provision of this License is held to be unenforceable, such provision shall be reformed only to the extent necessary to make it enforceable. This License shall be governed by the law of the jurisdiction specified in a notice contained within the Original Software (except to the extent applicable law, if any, provides otherwise), excluding such jurisdictions conflict-of-law provisions. Any litigation relating to this License shall be subject to the jurisdiction of the courts located in the jurisdiction and venue specified in a notice contained within the Original Software, with the losing party responsible for costs, including, without limitation, court costs and reasonable attorneys fees and expenses. The application of the United Nations Convention on Contracts for the International Sale of Goods is expressly excluded. Any law or regulation which provides that the language of a contract shall be construed against the drafter shall not apply to this License. You agree that You alone are responsible for compliance with the United States export administration regulations (and the export control laws and regulation of any other countries) when You use, distribute or otherwise make available any Covered Software.<br><br>10. RESPONSIBILITY FOR CLAIMS.<br><br>As between Initial Developer and the Contributors, each party is responsible for claims and damages arising, directly or indirectly, out of its utilization of rights under this License and You agree to work with Initial Developer and Contributors to distribute such responsibility on an equitable basis. Nothing herein is intended or shall be deemed to constitute any admission of liability.              '),(6,'GNU General Public License version 2 (GPLv2)','Copyright (C) 1989, 1991 Free Software Foundation, Inc.<br>51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA<br><br>Everyone is permitted to copy and distribute verbatim copies<br>of this license document, but changing it is not allowed.<br><br>Preamble<br><br>The licenses for most software are designed to take away your freedom to share and change it. By contrast, the GNU General Public License is intended to guarantee your freedom to share and change free software--to make sure the software is free for all its users. This General Public License applies to most of the Free Software Foundation\'s software and to any other program whose authors commit to using it. (Some other Free Software Foundation software is covered by the GNU Lesser General Public License instead.) You can apply it to your programs, too.<br><br>When we speak of free software, we are referring to freedom, not price. Our General Public Licenses are designed to make sure that you have the freedom to distribute copies of free software (and charge for this service if you wish), that you receive source code or can get it if you want it, that you can change the software or use pieces of it in new free programs; and that you know you can do these things.<br><br>To protect your rights, we need to make restrictions that forbid anyone to deny you these rights or to ask you to surrender the rights. These restrictions translate to certain responsibilities for you if you distribute copies of the software, or if you modify it.<br><br>For example, if you distribute copies of such a program, whether gratis or for a fee, you must give the recipients all the rights that you have. You must make sure that they, too, receive or can get the source code. And you must show them these terms so they know their rights.<br><br>We protect your rights with two steps: (1) copyright the software, and (2) offer you this license which gives you legal permission to copy, distribute and/or modify the software.<br><br>Also, for each author\'s protection and ours, we want to make certain that everyone understands that there is no warranty for this free software. If the software is modified by someone else and passed on, we want its recipients to know that what they have is not the original, so that any problems introduced by others will not reflect on the original authors\' reputations.<br><br>Finally, any free program is threatened constantly by software patents. We wish to avoid the danger that redistributors of a free program will individually obtain patent licenses, in effect making the program proprietary. To prevent this, we have made it clear that any patent must be licensed for everyone\'s free use or not licensed at all.<br><br>The precise terms and conditions for copying, distribution and modification follow.<br><br>GNU GENERAL PUBLIC LICENSE TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION<br><br>0. This License applies to any program or other work which contains a notice placed by the copyright holder saying it may be distributed under the terms of this General Public License. The \"Program\", below, refers to any such program or work, and a \"work based on the Program\" means either the Program or any derivative work under copyright law: that is to say, a work containing the Program or a portion of it, either verbatim or with modifications and/or translated into another language. (Hereinafter, translation is included without limitation in the term \"modification\".) Each licensee is addressed as \"you\".<br><br>Activities other than copying, distribution and modification are not covered by this License; they are outside its scope. The act of running the Program is not restricted, and the output from the Program is covered only if its contents constitute a work based on the Program (independent of having been made by running the Program). Whether that is true depends on what the Program does.<br><br>1. You may copy and distribute verbatim copies of the Program\'s source code as you receive it, in any medium, provided that you conspicuously and appropriately publish on each copy an appropriate copyright notice and disclaimer of warranty; keep intact all the notices that refer to this License and to the absence of any warranty; and give any other recipients of the Program a copy of this License along with the Program.<br><br>You may charge a fee for the physical act of transferring a copy, and you may at your option offer warranty protection in exchange for a fee.<br><br>2. You may modify your copy or copies of the Program or any portion of it, thus forming a work based on the Program, and copy and distribute such modifications or work under the terms of Section 1 above, provided that you also meet all of these conditions:<br><br>a) You must cause the modified files to carry prominent notices stating that you changed the files and the date of any change.<br><br>b) You must cause any work that you distribute or publish, that in whole or in part contains or is derived from the Program or any part thereof, to be licensed as a whole at no charge to all third parties under the terms of this License.<br><br>c) If the modified program normally reads commands interactively when run, you must cause it, when started running for such interactive use in the most ordinary way, to print or display an announcement including an appropriate copyright notice and a notice that there is no warranty (or else, saying that you provide a warranty) and that users may redistribute the program under these conditions, and telling the user how to view a copy of this License. (Exception: if the Program itself is interactive but does not normally print such an announcement, your work based on the Program is not required to print an announcement.)<br><br>These requirements apply to the modified work as a whole. If identifiable sections of that work are not derived from the Program, and can be reasonably considered independent and separate works in themselves, then this License, and its terms, do not apply to those sections when you distribute them as separate works. But when you distribute the same sections as part of a whole which is a work based on the Program, the distribution of the whole must be on the terms of this License, whose permissions for other licensees extend to the entire whole, and thus to each and every part regardless of who wrote it.<br><br>Thus, it is not the intent of this section to claim rights or contest your rights to work written entirely by you; rather, the intent is to exercise the right to control the distribution of derivative or collective works based on the Program.<br><br>In addition, mere aggregation of another work not based on the Program with the Program (or with a work based on the Program) on a volume of a storage or distribution medium does not bring the other work under the scope of this License.<br><br>3. You may copy and distribute the Program (or a work based on it, under Section 2) in object code or executable form under the terms of Sections 1 and 2 above provided that you also do one of the following:<br><br>a) Accompany it with the complete corresponding machine-readable source code, which must be distributed under the terms of Sections 1 and 2 above on a medium customarily used for software interchange; or,<br><br>b) Accompany it with a written offer, valid for at least three years, to give any third party, for a charge no more than your cost of physically performing source distribution, a complete machine-readable copy of the corresponding source code, to be distributed under the terms of Sections 1 and 2 above on a medium customarily used for software interchange; or,<br><br>c) Accompany it with the information you received as to the offer to distribute corresponding source code. (This alternative is allowed only for noncommercial distribution and only if you received the program in object code or executable form with such an offer, in accord with Subsection b above.)<br><br>The source code for a work means the preferred form of the work for making modifications to it. For an executable work, complete source code means all the source code for all modules it contains, plus any associated interface definition files, plus the scripts used to control compilation and installation of the executable. However, as a special exception, the source code distributed need not include anything that is normally distributed (in either source or binary form) with the major components (compiler, kernel, and so on) of the operating system on which the executable runs, unless that component itself accompanies the executable.<br><br>If distribution of executable or object code is made by offering access to copy from a designated place, then offering equivalent access to copy the source code from the same place counts as distribution of the source code, even though third parties are not compelled to copy the source along with the object code.<br><br>4. You may not copy, modify, sublicense, or distribute the Program except as expressly provided under this License. Any attempt otherwise to copy, modify, sublicense or distribute the Program is void, and will automatically terminate your rights under this License. However, parties who have received copies, or rights, from you under this License will not have their licenses terminated so long as such parties remain in full compliance.<br><br>5. You are not required to accept this License, since you have not signed it. However, nothing else grants you permission to modify or distribute the Program or its derivative works. These actions are prohibited by law if you do not accept this License. Therefore, by modifying or distributing the Program (or any work based on the Program), you indicate your acceptance of this License to do so, and all its terms and conditions for copying, distributing or modifying the Program or works based on it.<br><br>6. Each time you redistribute the Program (or any work based on the Program), the recipient automatically receives a license from the original licensor to copy, distribute or modify the Program subject to these terms and conditions. You may not impose any further restrictions on the recipients\' exercise of the rights granted herein. You are not responsible for enforcing compliance by third parties to this License.<br><br>7. If, as a consequence of a court judgment or allegation of patent infringement or for any other reason (not limited to patent issues), conditions are imposed on you (whether by court order, agreement or otherwise) that contradict the conditions of this License, they do not excuse you from the conditions of this License. If you cannot distribute so as to satisfy simultaneously your obligations under this License and any other pertinent obligations, then as a consequence you may not distribute the Program at all. For example, if a patent license would not permit royalty-free redistribution of the Program by all those who receive copies directly or indirectly through you, then the only way you could satisfy both it and this License would be to refrain entirely from distribution of the Program.<br><br>If any portion of this section is held invalid or unenforceable under any particular circumstance, the balance of the section is intended to apply and the section as a whole is intended to apply in other circumstances.<br><br>It is not the purpose of this section to induce you to infringe any patents or other property right claims or to contest validity of any such claims; this section has the sole purpose of protecting the integrity of the free software distribution system, which is implemented by public license practices. Many people have made generous contributions to the wide range of software distributed through that system in reliance on consistent application of that system; it is up to the author/donor to decide if he or she is willing to distribute software through any other system and a licensee cannot impose that choice.<br><br>This section is intended to make thoroughly clear what is believed to be a consequence of the rest of this License.<br><br>8. If the distribution and/or use of the Program is restricted in certain countries either by patents or by copyrighted interfaces, the original copyright holder who places the Program under this License may add an explicit geographical distribution limitation excluding those countries, so that distribution is permitted only in or among countries not thus excluded. In such case, this License incorporates the limitation as if written in the body of this License.<br><br>9. The Free Software Foundation may publish revised and/or new versions of the General Public License from time to time. Such new versions will be similar in spirit to the present version, but may differ in detail to address new problems or concerns.<br><br>Each version is given a distinguishing version number. If the Program specifies a version number of this License which applies to it and \"any later version\", you have the option of following the terms and conditions either of that version or of any later version published by the Free Software Foundation. If the Program does not specify a version number of this License, you may choose any version ever published by the Free Software Foundation.<br><br>10. If you wish to incorporate parts of the Program into other free programs whose distribution conditions are different, write to the author to ask for permission. For software which is copyrighted by the Free Software Foundation, write to the Free Software Foundation; we sometimes make exceptions for this. Our decision will be guided by the two goals of preserving the free status of all derivatives of our free software and of promoting the sharing and reuse of software generally.<br><br>NO WARRANTY<br><br>11. BECAUSE THE PROGRAM IS LICENSED FREE OF CHARGE, THERE IS NO WARRANTY FOR THE PROGRAM, TO THE EXTENT PERMITTED BY APPLICABLE LAW. EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES PROVIDE THE PROGRAM \"AS IS\" WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE PROGRAM IS WITH YOU. SHOULD THE PROGRAM PROVE DEFECTIVE, YOU ASSUME THE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.<br><br>12. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR REDISTRIBUTE THE PROGRAM AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR INABILITY TO USE THE PROGRAM (INCLUDING BUT NOT LIMITED TO LOSS OF DATA OR DATA BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES OR A FAILURE OF THE PROGRAM TO OPERATE WITH ANY OTHER PROGRAMS), EVEN IF SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.        '),(7,'GNU Lesser General Public License (LGPL)','Version 2.1, February 1999<br><br>Copyright (C) 1991, 1999 Free Software Foundation, Inc. 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301 USA Everyone is permitted to copy and distribute verbatim copies of this license document, but changing it is not allowed.<br><br>[This is the first released version of the Lesser GPL. It also counts as the successor of the GNU Library Public License, version 2, hence the version number 2.1.]<br><br>Preamble<br><br>The licenses for most software are designed to take away your freedom to share and change it. By contrast, the GNU General Public Licenses are intended to guarantee your freedom to share and change free software--to make sure the software is free for all its users.<br><br>This license, the Lesser General Public License, applies to some specially designated software packages--typically libraries--of the Free Software Foundation and other authors who decide to use it. You can use it too, but we suggest you first think carefully about whether this license or the ordinary General Public License is the better strategy to use in any particular case, based on the explanations below.<br><br>When we speak of free software, we are referring to freedom of use, not price. Our General Public Licenses are designed to make sure that you have the freedom to distribute copies of free software (and charge for this service if you wish); that you receive source code or can get it if you want it; that you can change the software and use pieces of it in new free programs; and that you are informed that you can do these things.<br><br>To protect your rights, we need to make restrictions that forbid distributors to deny you these rights or to ask you to surrender these rights. These restrictions translate to certain responsibilities for you if you distribute copies of the library or if you modify it.<br><br>For example, if you distribute copies of the library, whether gratis or for a fee, you must give the recipients all the rights that we gave you. You must make sure that they, too, receive or can get the source code. If you link other code with the library, you must provide complete object files to the recipients, so that they can relink them with the library after making changes to the library and recompiling it. And you must show them these terms so they know their rights.<br><br>We protect your rights with a two-step method: (1) we copyright the library, and (2) we offer you this license, which gives you legal permission to copy, distribute and/or modify the library.<br><br>To protect each distributor, we want to make it very clear that there is no warranty for the free library. Also, if the library is modified by someone else and passed on, the recipients should know that what they have is not the original version, so that the original author\'s reputation will not be affected by problems that might be introduced by others.<br><br>Finally, software patents pose a constant threat to the existence of any free program. We wish to make sure that a company cannot effectively restrict the users of a free program by obtaining a restrictive license from a patent holder. Therefore, we insist that any patent license obtained for a version of the library must be consistent with the full freedom of use specified in this license.<br><br>Most GNU software, including some libraries, is covered by the ordinary GNU General Public License. This license, the GNU Lesser General Public License, applies to certain designated libraries, and is quite different from the ordinary General Public License. We use this license for certain libraries in order to permit linking those libraries into non-free programs.<br><br>When a program is linked with a library, whether statically or using a shared library, the combination of the two is legally speaking a combined work, a derivative of the original library. The ordinary General Public License therefore permits such linking only if the entire combination fits its criteria of freedom. The Lesser General Public License permits more lax criteria for linking other code with the library.<br><br>We call this license the \"Lesser\" General Public License because it does Less to protect the user\'s freedom than the ordinary General Public License. It also provides other free software developers Less of an advantage over competing non-free programs. These disadvantages are the reason we use the ordinary General Public License for many libraries. However, the Lesser license provides advantages in certain special circumstances.<br><br>For example, on rare occasions, there may be a special need to encourage the widest possible use of a certain library, so that it becomes a de-facto standard. To achieve this, non-free programs must be allowed to use the library. A more frequent case is that a free library does the same job as widely used non-free libraries. In this case, there is little to gain by limiting the free library to free software only, so we use the Lesser General Public License.<br><br>In other cases, permission to use a particular library in non-free programs enables a greater number of people to use a large body of free software. For example, permission to use the GNU C Library in non-free programs enables many more people to use the whole GNU operating system, as well as its variant, the GNU/Linux operating system.<br><br>Although the Lesser General Public License is Less protective of the users\' freedom, it does ensure that the user of a program that is linked with the Library has the freedom and the wherewithal to run that program using a modified version of the Library.<br><br>The precise terms and conditions for copying, distribution and modification follow. Pay close attention to the difference between a \"work based on the library\" and a \"work that uses the library\". The former contains code derived from the library, whereas the latter must be combined with the library in order to run.<br><br>TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION<br><br>0. This License Agreement applies to any software library or other program which contains a notice placed by the copyright holder or other authorized party saying it may be distributed under the terms of this Lesser General Public License (also called \"this License\"). Each licensee is addressed as \"you\".<br><br>A \"library\" means a collection of software functions and/or data prepared so as to be conveniently linked with application programs (which use some of those functions and data) to form executables.<br><br>The \"Library\", below, refers to any such software library or work which has been distributed under these terms. A \"work based on the Library\" means either the Library or any derivative work under copyright law: that is to say, a work containing the Library or a portion of it, either verbatim or with modifications and/or translated straightforwardly into another language. (Hereinafter, translation is included without limitation in the term \"modification\".)<br><br>\"Source code\" for a work means the preferred form of the work for making modifications to it. For a library, complete source code means all the source code for all modules it contains, plus any associated interface definition files, plus the scripts used to control compilation and installation of the library.<br><br>Activities other than copying, distribution and modification are not covered by this License; they are outside its scope. The act of running a program using the Library is not restricted, and output from such a program is covered only if its contents constitute a work based on the Library (independent of the use of the Library in a tool for writing it). Whether that is true depends on what the Library does and what the program that uses the Library does.<br><br>1. You may copy and distribute verbatim copies of the Library\'s complete source code as you receive it, in any medium, provided that you conspicuously and appropriately publish on each copy an appropriate copyright notice and disclaimer of warranty; keep intact all the notices that refer to this License and to the absence of any warranty; and distribute a copy of this License along with the Library.<br><br>You may charge a fee for the physical act of transferring a copy, and you may at your option offer warranty protection in exchange for a fee.<br><br>2. You may modify your copy or copies of the Library or any portion of it, thus forming a work based on the Library, and copy and distribute such modifications or work under the terms of Section 1 above, provided that you also meet all of these conditions:<br><br>a) The modified work must itself be a software library.<br>b) You must cause the files modified to carry prominent notices stating that you changed the files and the date of any change.<br>c) You must cause the whole of the work to be licensed at no charge to all third parties under the terms of this License.<br>d) If a facility in the modified Library refers to a function or a table of data to be supplied by an application program that uses the facility, other than as an argument passed when the facility is invoked, then you must make a good faith effort to ensure that, in the event an application does not supply such function or table, the facility still operates, and performs whatever part of its purpose remains meaningful.<br>(For example, a function in a library to compute square roots has a purpose that is entirely well-defined independent of the application. Therefore, Subsection 2d requires that any application-supplied function or table used by this function must be optional: if the application does not supply it, the square root function must still compute square roots.)<br><br>These requirements apply to the modified work as a whole. If identifiable sections of that work are not derived from the Library, and can be reasonably considered independent and separate works in themselves, then this License, and its terms, do not apply to those sections when you distribute them as separate works. But when you distribute the same sections as part of a whole which is a work based on the Library, the distribution of the whole must be on the terms of this License, whose permissions for other licensees extend to the entire whole, and thus to each and every part regardless of who wrote it.<br><br>Thus, it is not the intent of this section to claim rights or contest your rights to work written entirely by you; rather, the intent is to exercise the right to control the distribution of derivative or collective works based on the Library.<br><br>In addition, mere aggregation of another work not based on the Library with the Library (or with a work based on the Library) on a volume of a storage or distribution medium does not bring the other work under the scope of this License. <br><br>3. You may opt to apply the terms of the ordinary GNU General Public License instead of this License to a given copy of the Library. To do this, you must alter all the notices that refer to this License, so that they refer to the ordinary GNU General Public License, version 2, instead of to this License. (If a newer version than version 2 of the ordinary GNU General Public License has appeared, then you can specify that version instead if you wish.) Do not make any other change in these notices.<br><br>Once this change is made in a given copy, it is irreversible for that copy, so the ordinary GNU General Public License applies to all subsequent copies and derivative works made from that copy.<br><br>This option is useful when you wish to copy part of the code of the Library into a program that is not a library.<br><br>4. You may copy and distribute the Library (or a portion or derivative of it, under Section 2) in object code or executable form under the terms of Sections 1 and 2 above provided that you accompany it with the complete corresponding machine-readable source code, which must be distributed under the terms of Sections 1 and 2 above on a medium customarily used for software interchange.<br><br>If distribution of object code is made by offering access to copy from a designated place, then offering equivalent access to copy the source code from the same place satisfies the requirement to distribute the source code, even though third parties are not compelled to copy the source along with the object code.<br><br>5. A program that contains no derivative of any portion of the Library, but is designed to work with the Library by being compiled or linked with it, is called a \"work that uses the Library\". Such a work, in isolation, is not a derivative work of the Library, and therefore falls outside the scope of this License.<br><br>However, linking a \"work that uses the Library\" with the Library creates an executable that is a derivative of the Library (because it contains portions of the Library), rather than a \"work that uses the library\". The executable is therefore covered by this License. Section 6 states terms for distribution of such executables.<br><br>When a \"work that uses the Library\" uses material from a header file that is part of the Library, the object code for the work may be a derivative work of the Library even though the source code is not. Whether this is true is especially significant if the work can be linked without the Library, or if the work is itself a library. The threshold for this to be true is not precisely defined by law.<br><br>If such an object file uses only numerical parameters, data structure layouts and accessors, and small macros and small inline functions (ten lines or less in length), then the use of the object file is unrestricted, regardless of whether it is legally a derivative work. (Executables containing this object code plus portions of the Library will still fall under Section 6.)<br><br>Otherwise, if the work is a derivative of the Library, you may distribute the object code for the work under the terms of Section 6. Any executables containing that work also fall under Section 6, whether or not they are linked directly with the Library itself.<br><br>6. As an exception to the Sections above, you may also combine or link a \"work that uses the Library\" with the Library to produce a work containing portions of the Library, and distribute that work under terms of your choice, provided that the terms permit modification of the work for the customer\'s own use and reverse engineering for debugging such modifications.<br><br>You must give prominent notice with each copy of the work that the Library is used in it and that the Library and its use are covered by this License. You must supply a copy of this License. If the work during execution displays copyright notices, you must include the copyright notice for the Library among them, as well as a reference directing the user to the copy of this License. Also, you must do one of these things:<br><br>a) Accompany the work with the complete corresponding machine-readable source code for the Library including whatever changes were used in the work (which must be distributed under Sections 1 and 2 above); and, if the work is an executable linked with the Library, with the complete machine-readable \"work that uses the Library\", as object code and/or source code, so that the user can modify the Library and then relink to produce a modified executable containing the modified Library. (It is understood that the user who changes the contents of definitions files in the Library will not necessarily be able to recompile the application to use the modified definitions.)<br>b) Use a suitable shared library mechanism for linking with the Library. A suitable mechanism is one that (1) uses at run time a copy of the library already present on the user\'s computer system, rather than copying library functions into the executable, and (2) will operate properly with a modified version of the library, if the user installs one, as long as the modified version is interface-compatible with the version that the work was made with.<br>c) Accompany the work with a written offer, valid for at least three years, to give the same user the materials specified in Subsection 6a, above, for a charge no more than the cost of performing this distribution.<br>d) If distribution of the work is made by offering access to copy from a designated place, offer equivalent access to copy the above specified materials from the same place.<br>e) Verify that the user has already received a copy of these materials or that you have already sent this user a copy.<br>For an executable, the required form of the \"work that uses the Library\" must include any data and utility programs needed for reproducing the executable from it. However, as a special exception, the materials to be distributed need not include anything that is normally distributed (in either source or binary form) with the major components (compiler, kernel, and so on) of the operating system on which the executable runs, unless that component itself accompanies the executable.<br><br>It may happen that this requirement contradicts the license restrictions of other proprietary libraries that do not normally accompany the operating system. Such a contradiction means you cannot use both them and the Library together in an executable that you distribute.<br><br>7. You may place library facilities that are a work based on the Library side-by-side in a single library together with other library facilities not covered by this License, and distribute such a combined library, provided that the separate distribution of the work based on the Library and of the other library facilities is otherwise permitted, and provided that you do these two things:<br><br>a) Accompany the combined library with a copy of the same work based on the Library, uncombined with any other library facilities. This must be distributed under the terms of the Sections above.<br>b) Give prominent notice with the combined library of the fact that part of it is a work based on the Library, and explaining where to find the accompanying uncombined form of the same work.<br>8. You may not copy, modify, sublicense, link with, or distribute the Library except as expressly provided under this License. Any attempt otherwise to copy, modify, sublicense, link with, or distribute the Library is void, and will automatically terminate your rights under this License. However, parties who have received copies, or rights, from you under this License will not have their licenses terminated so long as such parties remain in full compliance.<br><br>9. You are not required to accept this License, since you have not signed it. However, nothing else grants you permission to modify or distribute the Library or its derivative works. These actions are prohibited by law if you do not accept this License. Therefore, by modifying or distributing the Library (or any work based on the Library), you indicate your acceptance of this License to do so, and all its terms and conditions for copying, distributing or modifying the Library or works based on it.<br><br>10. Each time you redistribute the Library (or any work based on the Library), the recipient automatically receives a license from the original licensor to copy, distribute, link with or modify the Library subject to these terms and conditions. You may not impose any further restrictions on the recipients\' exercise of the rights granted herein. You are not responsible for enforcing compliance by third parties with this License.<br><br>11. If, as a consequence of a court judgment or allegation of patent infringement or for any other reason (not limited to patent issues), conditions are imposed on you (whether by court order, agreement or otherwise) that contradict the conditions of this License, they do not excuse you from the conditions of this License. If you cannot distribute so as to satisfy simultaneously your obligations under this License and any other pertinent obligations, then as a consequence you may not distribute the Library at all. For example, if a patent license would not permit royalty-free redistribution of the Library by all those who receive copies directly or indirectly through you, then the only way you could satisfy both it and this License would be to refrain entirely from distribution of the Library.<br><br>If any portion of this section is held invalid or unenforceable under any particular circumstance, the balance of the section is intended to apply, and the section as a whole is intended to apply in other circumstances.<br><br>It is not the purpose of this section to induce you to infringe any patents or other property right claims or to contest validity of any such claims; this section has the sole purpose of protecting the integrity of the free software distribution system which is implemented by public license practices. Many people have made generous contributions to the wide range of software distributed through that system in reliance on consistent application of that system; it is up to the author/donor to decide if he or she is willing to distribute software through any other system and a licensee cannot impose that choice.<br><br>This section is intended to make thoroughly clear what is believed to be a consequence of the rest of this License.<br><br>12. If the distribution and/or use of the Library is restricted in certain countries either by patents or by copyrighted interfaces, the original copyright holder who places the Library under this License may add an explicit geographical distribution limitation excluding those countries, so that distribution is permitted only in or among countries not thus excluded. In such case, this License incorporates the limitation as if written in the body of this License.<br><br>13. The Free Software Foundation may publish revised and/or new versions of the Lesser General Public License from time to time. Such new versions will be similar in spirit to the present version, but may differ in detail to address new problems or concerns.<br><br>Each version is given a distinguishing version number. If the Library specifies a version number of this License which applies to it and \"any later version\", you have the option of following the terms and conditions either of that version or of any later version published by the Free Software Foundation. If the Library does not specify a license version number, you may choose any version ever published by the Free Software Foundation.<br><br>14. If you wish to incorporate parts of the Library into other free programs whose distribution conditions are incompatible with these, write to the author to ask for permission. For software which is copyrighted by the Free Software Foundation, write to the Free Software Foundation; we sometimes make exceptions for this. Our decision will be guided by the two goals of preserving the free status of all derivatives of our free software and of promoting the sharing and reuse of software generally.<br><br>NO WARRANTY<br><br>15. BECAUSE THE LIBRARY IS LICENSED FREE OF CHARGE, THERE IS NO WARRANTY FOR THE LIBRARY, TO THE EXTENT PERMITTED BY APPLICABLE LAW. EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES PROVIDE THE LIBRARY \"AS IS\" WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE LIBRARY IS WITH YOU. SHOULD THE LIBRARY PROVE DEFECTIVE, YOU ASSUME THE COST OF ALL NECESSARY SERVICING, REPAIR OR CORRECTION.<br><br>16. IN NO EVENT UNLESS REQUIRED BY APPLICABLE LAW OR AGREED TO IN WRITING WILL ANY COPYRIGHT HOLDER, OR ANY OTHER PARTY WHO MAY MODIFY AND/OR REDISTRIBUTE THE LIBRARY AS PERMITTED ABOVE, BE LIABLE TO YOU FOR DAMAGES, INCLUDING ANY GENERAL, SPECIAL, INCIDENTAL OR CONSEQUENTIAL DAMAGES ARISING OUT OF THE USE OR INABILITY TO USE THE LIBRARY (INCLUDING BUT NOT LIMITED TO LOSS OF DATA OR DATA BEING RENDERED INACCURATE OR LOSSES SUSTAINED BY YOU OR THIRD PARTIES OR A FAILURE OF THE LIBRARY TO OPERATE WITH ANY OTHER SOFTWARE), EVEN IF SUCH HOLDER OR OTHER PARTY HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES.<br>'),(8,'The MIT License (MIT)','Copyright (c) <span class=\"LicenseFieldValue\"><span class=\"Disabled\">(Year)</span></span> <span class=\"LicenseFieldValue\"><span class=\"Disabled\">(Copyright Holders)</span></span><br><br>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:<br><br>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.<br><br>THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.           '),(9,'MIT','Copyright (c) <span class=\"LicenseFieldValue\"><span class=\"Disabled\">(Year)</span></span> <span class=\"LicenseFieldValue\"><span class=\"Disabled\">(Copyright Holders)</span></span><br><br>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the \"Software\"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:<br><br>The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.<br><br>THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.           ');
/*!40000 ALTER TABLE `licensemaster` ENABLE KEYS */;
UNLOCK TABLES;

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
  `memberName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`projectId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectdetail`
--

LOCK TABLES `projectdetail` WRITE;
/*!40000 ALTER TABLE `projectdetail` DISABLE KEYS */;
INSERT INTO `projectdetail` VALUES (1,1,'2012-10-29','ddddd'),(1,2,'2012-10-29','c'),(1,3,'2012-10-29','bbbb'),(1,4,'2012-10-29','aaaa'),(1,5,'2012-11-03','meh'),(1,8,'2012-11-03','meh'),(2,5,'2012-11-03','meh'),(2,8,'2012-11-03','meh'),(5,8,'2012-11-06',NULL);
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
INSERT INTO `projectfollower` VALUES (1,6,'2012-11-04'),(3,8,'2012-11-04');
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectinvitation`
--

LOCK TABLES `projectinvitation` WRITE;
/*!40000 ALTER TABLE `projectinvitation` DISABLE KEYS */;
INSERT INTO `projectinvitation` VALUES (1,1,7,1,'2012-11-06','No','Pending'),(2,7,8,5,'2012-11-06','No','accept');
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
  `iUrl` varchar(50) DEFAULT NULL,
  `licenseId` int(11) DEFAULT NULL,
  `projDoc` blob,
  PRIMARY KEY (`projId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectmaster`
--

LOCK TABLES `projectmaster` WRITE;
/*!40000 ALTER TABLE `projectmaster` DISABLE KEYS */;
INSERT INTO `projectmaster` VALUES (1,'a','asdasdasdasdasfsadfsdefsdfsdfsdfsdfs',8,15,55,'public','images/1.jpg',1,'<b><i>Hello how are you</i></b>'),(2,'b','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',2,55,55,'public','images/userDefault.svg',1,NULL),(3,'b','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',2,5,55,'public','images/userDefault.svg',1,NULL),(4,'c','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',2,51,55,'public','images/userDefault.svg',1,NULL),(5,'d','aaaaaasdj asjdh jashf jas fjkh ashjkf ajksh ',9,86,55,'public','images/userDefault.svg',1,NULL);
/*!40000 ALTER TABLE `projectmaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projectmember`
--

DROP TABLE IF EXISTS `projectmember`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectmember` (
  `projId` int(11) NOT NULL DEFAULT '0',
  `userId` int(11) NOT NULL DEFAULT '0',
  `memberName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`userId`,`projId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectmember`
--

LOCK TABLES `projectmember` WRITE;
/*!40000 ALTER TABLE `projectmember` DISABLE KEYS */;
INSERT INTO `projectmember` VALUES (1,1,'abcd'),(1,2,'kjjhj'),(1,3,'jkjhkjj');
/*!40000 ALTER TABLE `projectmember` ENABLE KEYS */;
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
-- Table structure for table `projectreview`
--

DROP TABLE IF EXISTS `projectreview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projectreview` (
  `projId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `review` varchar(500) DEFAULT NULL,
  `rate` int(11) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `reviewId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`reviewId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projectreview`
--

LOCK TABLES `projectreview` WRITE;
/*!40000 ALTER TABLE `projectreview` DISABLE KEYS */;
INSERT INTO `projectreview` VALUES (1,8,'mast project',4,'2012-11-06 00:00:00',1),(1,5,'sample text',4,'2012-11-06 00:00:00',2),(1,6,'sample text',4,'2012-11-06 00:00:00',3),(1,7,'s text',4,'2012-11-06 00:00:00',4),(1,9,'s text',4,'2012-11-06 00:00:00',5);
/*!40000 ALTER TABLE `projectreview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `projecttags`
--

DROP TABLE IF EXISTS `projecttags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projecttags` (
  `projectId` int(11) NOT NULL DEFAULT '0',
  `tagId` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`projectId`,`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projecttags`
--

LOCK TABLES `projecttags` WRITE;
/*!40000 ALTER TABLE `projecttags` DISABLE KEYS */;
/*!40000 ALTER TABLE `projecttags` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projecttask`
--

LOCK TABLES `projecttask` WRITE;
/*!40000 ALTER TABLE `projecttask` DISABLE KEYS */;
INSERT INTO `projecttask` VALUES (1,1,1,'2012-10-29','Coding'),(2,1,2,'2012-10-31','Coding'),(3,1,3,'2012-10-31','analysis'),(4,1,2,'2012-10-30','Sample Task'),(5,1,3,'2012-10-30','Sample tsak1'),(6,1,3,'2012-10-29','sampletask 2'),(7,1,1,'2012-10-30','sdasda'),(8,1,1,'2012-10-30','sassssss'),(9,1,2,'2012-10-29','qwertty'),(10,1,2,'2012-10-29','qwerttysdfsdfsdf'),(11,1,3,'2012-10-29','qwerttysdfsdfsdf');
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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projecttaskdetail`
--

LOCK TABLES `projecttaskdetail` WRITE;
/*!40000 ALTER TABLE `projecttaskdetail` DISABLE KEYS */;
INSERT INTO `projecttaskdetail` VALUES (7,2,'Design','Incomplete','2012-10-27'),(8,2,'Analysis','Incomplete','2012-10-27'),(9,3,'Design','Incomplete','2012-10-27'),(10,3,'Analysis','Incomplete','2012-10-27'),(11,3,'asd','Incomplete','2012-10-27'),(12,4,'Sample Sub task','Incomplete','2012-10-28'),(13,4,'Sample Subtask 1','Incomplete','2012-10-28'),(14,4,'Sample Subtask','Incomplete','2012-10-28'),(15,5,'Sample Sub task','Incomplete','2012-10-28'),(16,5,'Sample Subtask 1','Incomplete','2012-10-28'),(17,5,'Sample Subtask','Incomplete','2012-10-28'),(18,5,'aaaaaaa','Incomplete','2012-10-28'),(19,6,'asdasd','Incomplete','2012-10-28'),(20,7,'asdasd','Incomplete','2012-10-28'),(21,7,'asdasd','Incomplete','2012-10-28'),(22,8,'dfdsf','Complete','2012-10-28'),(23,8,'dfdf','Complete','2012-10-28'),(24,9,'dfdsf','Incomplete','2012-10-28'),(25,9,'dfdf','Incomplete','2012-10-28'),(26,9,'asdasd','Incomplete','2012-10-28');
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
INSERT INTO `projecttaskmember` VALUES (3,1),(3,2),(3,3),(4,2),(5,2),(6,1),(6,2),(6,3),(7,1),(7,2),(7,3),(7,5),(7,6),(8,1),(8,3),(9,1),(9,3),(10,1),(10,2),(11,1),(11,2);
/*!40000 ALTER TABLE `projecttaskmember` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tagmaster`
--

DROP TABLE IF EXISTS `tagmaster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tagmaster` (
  `tagId` int(11) NOT NULL AUTO_INCREMENT,
  `tagName` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tagId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagmaster`
--

LOCK TABLES `tagmaster` WRITE;
/*!40000 ALTER TABLE `tagmaster` DISABLE KEYS */;
/*!40000 ALTER TABLE `tagmaster` ENABLE KEYS */;
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
  `username` varchar(40) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `jDate` date DEFAULT NULL,
  `verified` varchar(10) DEFAULT NULL,
  `iUrl` varchar(50) DEFAULT NULL,
  `verificationId` varchar(50) DEFAULT NULL,
  `nick` varchar(20) DEFAULT NULL,
  `aboutUser` varchar(500) DEFAULT NULL,
  `forgotPassId` varchar(50) DEFAULT NULL,
  `rand` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usermaster`
--

LOCK TABLES `usermaster` WRITE;
/*!40000 ALTER TABLE `usermaster` DISABLE KEYS */;
INSERT INTO `usermaster` VALUES (5,'meherzad@gmail.com','12345','2012-10-23','yes','images/userDefault.svg','b8c0d7bc879847a44f22faf23f67a04a','Rocky',NULL,NULL,NULL),(6,'meherzad','d10906c3dac1172d4f60bd41f224ae75','2012-10-25','no','images/userDefault.svg','416f139a1d7935c0b55757a50152867d','MOnkey',NULL,NULL,NULL),(7,'meherzad.lahewala@gmail.com','827ccb0eea8a706c4c34a16891f84e7b','2012-11-02','no','images/userDefault.svg','6b89856a660fdf299f09d1c3993617fc','meh',NULL,NULL,NULL),(8,'abc@gmail.com','827ccb0eea8a706c4c34a16891f84e7b','2012-11-02','yes','images/userPic/8.jpg','3f009d72559f51e7e454b16e5d0687a1','abc','Hi Im abc@gmail.c0o0m',NULL,NULL),(9,'201112025@daiict.ac.in','e99a18c428cb38d5f260853678922e03','2012-11-02','yes','images/userDefault.svg','33ab7ff92495309408e80cf32e8e6f30','abc',NULL,NULL,'ad5a3fd62a042c462e9172f505a96b0d'),(10,'abhishekverma.xander@gmail.com','f589a6959f3e04037eb2b3eb0ff726ac','2012-11-02','yes','images/userDefault.svg','bda95e44ff465c8247ce100d64220d17','Xander',NULL,NULL,NULL);
/*!40000 ALTER TABLE `usermaster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usernotification`
--

DROP TABLE IF EXISTS `usernotification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usernotification` (
  `notId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `notification` varchar(100) DEFAULT NULL,
  `timeStamp` datetime DEFAULT NULL,
  `notType` varchar(20) DEFAULT NULL,
  `rID` int(11) DEFAULT NULL,
  PRIMARY KEY (`notId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usernotification`
--

LOCK TABLES `usernotification` WRITE;
/*!40000 ALTER TABLE `usernotification` DISABLE KEYS */;
INSERT INTO `usernotification` VALUES (1,8,'Friend request new userr','2012-11-03 00:00:00','invitation',3),(2,8,'Friend request','2012-11-03 00:00:00','bug',3);
/*!40000 ALTER TABLE `usernotification` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-06 11:26:27
