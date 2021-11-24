/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 127.0.0.1:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 23/11/2021 02:08:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_addres
-- ----------------------------
DROP TABLE IF EXISTS `t_addres`;
CREATE TABLE `t_addres`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `u_id` int(4) NOT NULL,
  `addres` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_addres
-- ----------------------------

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_price` decimal(10, 2) NOT NULL,
  `book_info` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `book_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `book_publish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `book_sale_price` decimal(10, 2) NULL DEFAULT NULL,
  `book_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type_id` int(20) NOT NULL,
  `book_quantity` int(100) NOT NULL,
  `book_sale_qty` int(100) NOT NULL,
  `book_hot` int(4) NOT NULL,
  `book_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `type_id`(`type_id`) USING BTREE,
  CONSTRAINT `type_id` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_book
-- ----------------------------
INSERT INTO `t_book` VALUES (2, 'ECMAScript 6 入门教程', 110.00, '《ECMAScript 6 入门教程》是一本开源的 JavaScript 语言教程，全面介绍 ECMAScript 6 新引入的语法特性。 本书覆盖 ES6 与上一个版本 ES5 的所有不同之处，对涉及的语法知识给予详细介绍，并给出大量简洁易懂的示例代码。 本书为中级难度，适合已经掌握 ES5 的读者，用来了解这门语言的最新发展；也可当作参考手册，查寻新增的语法点。 如果你是 JavaScript 语言的初学者，建议先学完《JavaScript 语言入门教程》，再来看本书。', '阮一峰', '2021-11-06 18:48:06', '电子工业出版社', 99.00, '/img/bstore/b0008.jpg', 1, 200, 10, 0, 'a8fa7cd323096c79750801d5bcc1a467');
INSERT INTO `t_book` VALUES (3, 'Java 8函数式编程', 35.00, '图灵程序设计丛书·Java系列 (共55册), 这套丛书还有《Hibernate 基础教程》,《Spring攻略》,《深入解析Spring MVC与Web Flow》,《EJB 3实战》,《Java测试驱动开发》 等。 喜欢读\"Java 8函数式编...', '[英] Richard Warburton', '2021-11-08 18:52:36', '图灵出品', 30.40, '/img/bstore/b0004.jpg', 1, 270, 300, 1, '54e9f32483bbd1ae16eb999454b12fda');
INSERT INTO `t_book` VALUES (4, 'Sping Cloud微服务', 65.99, 'MSCode微服务平台框架是基于微服务分布式和Activiti7工作流,有代码生成器和表单设计器,后端为微服务和单体版,前端为Vue,React和跨11端版,提供所有源码的企业级快速开发平台', '尹吉欢', '2021-11-07 18:58:09', '机械工业出版社', 63.90, '/img/bstore/b0006.jpg', 1, 0, 500, 0, 'd33b6ea77bf9f458819124e16fb4ebdf');
INSERT INTO `t_book` VALUES (5, '鸟哥的Linux私房菜', 120.00, '本书分为五大部分，每部分都各具特色。内容涵盖了Linux 的规划与安装，认识Linux 文件、目录与磁盘格式，学习Shell 与Shell Scripts，Linux 用户管理与Linux 系统管理等。依序学习，让您奠定Linux 的基础，跨出成功的第 一步。', '鸟哥', '2021-11-03 19:03:10', '人民邮电出版社', NULL, '/img/bstore/b0007.jpg', 1, 20, 11, 1, '72a5473df0a4abfb5cb57f1eb016dfa4');
INSERT INTO `t_book` VALUES (6, 'JavaScript高级程序设计', 160.00, '本书是JavaScript经典图书的新版。第4版涵盖ECMAScript 2019，全面、深入地介绍了JavaScript开发者必须掌握的前端开发技术，涉及JavaScript的基础特性和高级特性。书中详尽讨论了JavaScript的各个方面，从JavaScript的起源开始，逐步讲解到新出现的技术，其中重点介绍ECMAScript和DOM标准。在此基础上，接下来的各章揭示了JavaScript的基本概念，包括类、期约、迭代器、代理，等等。另外，书中深入探讨了客户端检测、事件、动画、表单、错误处理及JSON。本书同时也介绍了近几年来涌现的重要新规范，包括Fetch API、模块、工作者线程、服务线程以及大量新API。', '[美] 马特·弗里斯比', '2021-11-03 19:06:58', '图灵出品', 96.80, '/img/bstore/b0001.jpg', 1, 30, 0, 0, 'aa15b3c0a8d71484b24440128f8fa2ce');
INSERT INTO `t_book` VALUES (7, '射雕英雄传全四册', 145.00, '射雕英雄传（共4册）》是金庸武侠小说创作的代表作品，也是金庸拥有读者多的作品之一。故事讲述了，南宋年间，随丈夫杨铁心流落江南牛家村的包惜弱救了金国王子完颜洪烈，却害得丈夫和义兄郭啸天两家家破人亡。郭啸天的妻子逃到蒙古大漠，生下遗腹子郭靖。傻小子郭靖得到丐帮帮主洪七公传授绝技“降龙十八掌”，更赢得心上人蓉儿芳心。坚毅淳朴的傻小子终成一代大侠。包惜弱和杨铁心之子杨康认贼作父，成了金国的小王子，最终害人害己，惨死在牛家村。《射雕英雄传(共4册）》一书阐释了侠义精神的真谛——侠之大者、为国为民。', '金庸', '2021-11-10 19:11:50', '广州出版社', 92.30, '/img/bstore/b0009.jpg', 13, 10, 100, 1, 'ecce31780de30bdf3d3134fa4cf014fa');
INSERT INTO `t_book` VALUES (8, '平凡的世界全3册', 138.00, '《平凡的世界（全三部）》是一段平凡却热血、温暖又动人的成长故事，小说以孙少平与孙少安两兄弟为主角，讲述他们在生活中面临重重困难与挑战，却依然无畏前行的人生历程。《平凡的世界》深刻展示了普通人在大时代中走过的平凡却不平庸的道路，细腻书写亲情、爱情和友情，饱含真善美和昂扬向上的力量，今天读来依然让人充满共鸣，更给人以激励。《平凡的世界》也是一部跨时代的经典，在反映时代的同时超_越时代，散发出经久不衰的魅力。', '路遥', '2021-11-11 19:21:07', '北京出版集团', 101.80, '/img/bstore/b0010.jpg', 13, 12, 10, 0, '6678ade4e73ae8d78c2ff87fcf70bf30');
INSERT INTO `t_book` VALUES (9, '三体全集共3册', 93.00, '《三体全集（地球往事+黑暗森林+死神永生）（京东套装共3册）》讲的是在如火如荼进行的同时，军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……', '刘慈欣', '2021-11-11 19:24:34', '重庆出版社', 55.80, '/img/bstore/b0011.jpg', 13, 25, 13, 0, 'f79ee3bd6c5e83742f9b4a555859a73a');
INSERT INTO `t_book` VALUES (10, '史蒂夫·乔布斯传', 68.00, '2011年夏天，在史蒂夫·乔布斯还感觉他能够再次战胜癌症时，他建议我以他要辞去苹果CEO职务来结束本书，而他正打算在8月底公布这一消息。我已经将缺少结尾部分的原稿方案交给了出版社。就在我交上z终修订版之前，我和乔布斯一起讨论了书中使用过的许多故事，包括一些我认为他或许不怎么喜欢的事。', '[美] 沃尔特·艾萨克森', '2021-11-03 19:29:08', '中信出版社', 43.40, '/img/bstore/b0012.jpg', 24, 12, 34, 1, '21ac29696af9ca8670dcade8128e1f4c');
INSERT INTO `t_book` VALUES (11, '曾国藩传', 49.00, '《曾国藩传》讲述了晚清重臣曾国藩跌宕起伏的一生：步入仕途连升十级，后创办湘军、镇压太平天国、倡导洋务运动，为挽救晚清政府鞠躬尽瘁，成为一代重臣，最终却落得个毁誉参半的结局。', '梅寒', '2021-11-10 19:39:49', '江苏凤凰文艺出版社', 41.20, '/img/bstore/b0013.jpg', 24, 26, 36, 1, 'b26a7eb501e9c4dcc0a04c24cddd59a9');
INSERT INTO `t_book` VALUES (12, '知行合一王阳明', 36.00, '在蛮荒的龙场，王阳明悟出了“圣人之道，吾性自足”，即人人皆有良知。而在血腥的沙场和险恶的朝堂，让龙场悟道实际发挥作用的，是“知行合一”，即遵循内心的良知，便能达到宁静于内、无敌于外的境界。', '度阴山', '2021-11-03 19:44:02', '北京联合出版公司', NULL, '/img/bstore/b0014.jpg', 24, 20, 100, 0, 'f2556316b7bd150335148f90b33fce44');
INSERT INTO `t_book` VALUES (13, '新疆旅行指南', 96.00, '她是美食之地：大盘鸡、拉条子、烤羊肉、烤包子、馕坑肉、抓饭、缸子肉、丸子面、米肠子、面肺子、纳仁、鸽子汤、奶皮茶、哈密瓜、香梨、白杏、大枣、无花果、葡萄干、沙朗刀克……', '澳大利亚Lonely Planet公司', '2021-11-04 19:50:14', '中国地图出版社', NULL, '/img/bstore/b0015.jpg', 16, 200, 10, 1, '6504c97ebbc615cf79c705362393a1f0');
INSERT INTO `t_book` VALUES (14, '走遍中国：四川', 49.00, '《走遍中国：四川（第四版）》更新版全面升级为全彩版，不仅保持了“走遍中国”系列“以文化引导旅行”的良好口碑，还在“四川解读”部分增加了一篇《四川好耍》，并重新演绎了蜀道的历史与现状，增加了一篇《蜀道：连通古今的千年古道》，同时，还增加了一个全新的篇章“四川经典”，介绍四川值得尝试的事情、值得品尝的美食、重中之重的景点、有特色的节庆，以及独具特色的主题线路。', '《走遍中国》编辑部', '2021-11-11 19:54:37', '中国旅游出版社', 34.20, '/img/bstore/b0016.jpg', 16, 100, 500, 0, 'bf172b2c4c3eb3ab79ad11ccf891ffff');
INSERT INTO `t_book` VALUES (15, '法国旅行指南', 178.00, '法国向来以其不变的随意文化吸引着游客，那种氛围随处可见于咖啡馆露台、乡村集市，还有把当日特菜用粉笔写在黑板上的小资酒馆。而在法国又随处可见世界知名的艺术和建筑，罗马式教堂和文艺复兴风格的城堡，标志性的建筑举世闻名，还有许多尚不为人知的后起之秀。', '澳大利亚Lonely Planet公司', '2021-11-09 19:58:35', '中国地图出版社', NULL, '/img/bstore/b0017.jpg', 16, 150, 200, 0, '6aafebaf994d371dd45c5ccd3b267414');
INSERT INTO `t_book` VALUES (16, '影响未来的新科技新产业', 58.00, '《影响未来的新科技新产业》。尽管同属新兴领域，普遍具有颠覆性和应用前景广的特点，但现阶段,新科技在产业化程度、未来的市场潜力、资本接入方式、政府政策跟进等方面参差不齐，仍存在较大差异。', '中研组', '2021-11-18 20:04:15', '中信出版社', 40.90, '/img/bstore/b0018.jpg', 9, 10, 20, 1, 'ae5a05d7aabe926717103d13d03be31e');
INSERT INTO `t_book` VALUES (17, '硬科技', 79.80, '本书是在科技部科技创新战略研究专项的支持下集体研究形成的理论成果，也是在推动硬科技发展的过程中形成的实践成果。本书立足于科技自立自强的国家发展战略需求，深入介绍了发展硬科技的时代背景和重大意义，系统地定义了“硬科技”的概念，并赋予其丰富的内涵。', '贾敬敦，米磊，于磊', '2021-11-10 20:08:36', '人民邮电出版社', NULL, '/img/bstore/b0019.jpg', 9, 30, 10, 1, '03f811a72df371881b4a9b447e6ee891');
INSERT INTO `t_book` VALUES (18, '科技之巅3', 99.00, '《麻省理工科技评论》从2001年开始，每年都会公布“10大全球突破性技术”，即TR10（Technology Review 10），并预测其大规模商业化的潜力，以及对人类生活和社会的重大影响。', '麻省理工科技评论 ', '2021-11-08 20:11:58', '人民邮电出版社', NULL, '/img/bstore/b0020.jpg', 9, 100, 100, 0, '1472646c478b6f1a61e9f457e8d504cb');
INSERT INTO `t_book` VALUES (19, '自律的人生更自由', 46.00, '在我们的生活中，各种消极诱惑层出不穷，如果不懂得节制自己的欲望，放任懒散成为习惯、不自律成为常态，那么我们终将沦为欲望的奴隶，我们的人生也势必随之走向痛苦和平庸。对美好人生的期待，值得我们对自己严格一点儿。', '小椰子', '2021-11-09 20:18:48', '古吴轩出版社', 25.30, '/img/bstore/b0021.jpg', 11, 90, 80, 0, 'd216fc7abc4a91f86d707e2aa789a5b3');
INSERT INTO `t_book` VALUES (20, '愿世间所有美好，与你环环相扣', 48.00, '嘿，陌生人，你还好吗？\r\n\r\n我是易小宛，用温暖的文字给你安慰。\r\n\r\n我们的人生可以有一段伤痛的经历，\r\n\r\n但是不要允许自己一辈子都在过伤痛的人生。', '易小宛', '2021-11-09 20:23:07', '中国水利水电出版社', 43.60, '/img/bstore/b0022.jpg', 11, 20, 30, 0, '81716fb25b91635c602f830ab6cc1dd9');
INSERT INTO `t_book` VALUES (21, '格局', 39.80, '格局是一种气魄、一种胸襟，也是一种智慧，是我们为人处世的法宝，更是获得成功的奥秘。格局决定着你的未来！\r\n\r\n本书旨在指导读者如何颠覆传统思维方式，打破格局框架，为未来赢得先机。人生的格局在于你如何看待自己，在于你结交什么样的朋友，在于你如何选择未来的道路，在于你面临困境时的应对。', '月夜生凉', '2021-11-09 20:28:39', '江苏凤凰文艺出版社', 33.00, '/img/bstore/b0023.jpg', 11, 30, 20, 1, '9d0b48e12a8c66f0e58e3e8eb3a0add1');
INSERT INTO `t_book` VALUES (22, '世界名枪鉴赏指南', 69.00, '《世界名枪鉴赏指南（珍藏版 第3版）/世界武器鉴赏系列》在第2版的基础上进行了精心修订，使其内容更新、更全，设计更美观。\r\n　　与第2版相比，《世界名枪鉴赏指南（珍藏版 第3版）/世界武器鉴赏系列》删除了少数老旧的枪械，同时新增了多种新式枪械，并替换了一些质量较差的配图，补充了观赏性较强的精美大图。', '《深度军事》编委会', '2021-11-11 20:38:05', '清华大学出版社', 64.80, '/img/bstore/b0024.jpg', 22, 11, 12, 0, '9a28c4fd4975336b7030b9f0157f40c9');
INSERT INTO `t_book` VALUES (23, '时空穿行', 57.80, '《时空穿行(中国乡村人类学世纪回访)》对20世纪80年代以来中国云南大理西镇、广东潮州凤凰村、华南茶山等八个代表性乡村田野进行调查，探讨了中国乡村文化的多样性、宗族制度、农民社会等课题。', '庄孔韶', '2021-11-17 20:49:15', '中国人民大学出版社', 77.58, '/img/bstore/b0025.jpg', 18, 14, 12, 0, 'b17ac9753746a3062ecbaba0afcc95db');
INSERT INTO `t_book` VALUES (24, '感悟党史', 53.30, '\r\n感悟党史\r\n关注 分享举报\r\n企业批量购书\r\n本书对党史研究的现状和发展方向做了高屋建瓴的解读，对当代党史研究工作具有重要的理论指导意义。这是作者近年来具体指导党史研究工作经验的总结，从中不难发现党中央对党史研究工作的高度重视和以一以贯之的指导方针。此外，本书稿还荟萃了近年来作者本人研究中共党史的一系列重要成果。', '龙新民', '2021-11-17 21:07:05', '人民出版社', 68.00, '/img/bstore/b0026.jpg', 23, 10, 20, 0, 'fdc1a5b4ddb4a341a3ebf6f39b9467b4');
INSERT INTO `t_book` VALUES (25, '影响力（经典版）', 41.20, '自1986年出版以来，作为获得美国心理协会、美国心理学基金会年度大奖提名的西奥迪尼经典著作，本书已经成为史上*强大、*震摄人心、*诡谲的心理学畅销书，31年来，被翻译成26种文字广为传播，全球销量超过500万册。时至今日，本书仍位列图书排行榜之中，并雄踞消费者行为学和应用心理学类畅销书榜首。', '[美] 罗伯特·B·西奥迪尼', '2021-11-12 21:14:44', '北京联合出版社', 54.90, '/img/bstore/b0027.jpg', 4, 12, 21, 1, '760e1afc2f8d6b84f7ee9d4b05d4aef7');
INSERT INTO `t_book` VALUES (26, '所谓情商高，就是会说话', 32.00, '说话不只是一种“感觉”，还是一门“技术”！就像烹饪有食谱一样，说话也有它的“秘方”。古往今来，但凡不通说话之道者，都难成大事，而能成事者，一定在语言方面具有其独特的能力。一句恰到好处的话，甚至可以改变一个人的命运。人际沟通中怎样措辞？怎样把握说话的场合和时机？如何领略说话精髓，悟透说话之道，很快在众人中脱颖而出？\r\n\r\n说话不只是一种“感觉”，还是一门“技术”！就像烹饪有食谱一样，说话也有它的“秘方”。古往今来，但凡不通说话之道者，都难成大事，而能成事者，一定在语言方面具有其独特的能力。一句恰到好处的话，甚至可以改变一个人的命运。人际沟通中怎样措辞？怎样把握说话的场合和时机？如何领略说话精髓，悟透说话之道，很快在众人中脱颖而出？\r\n\r\n说话不只是一种“感觉”，还是一门“技术”！就像烹饪有食谱一样，说话也有它的“秘方”。古往今来，但凡不通说话之道者，都难成大事，而能成事者，一定在语言方面具有其独特的能力。一句恰到好处的话，甚至可以改变一个人的命运。人际沟通中怎样措辞？怎样把握说话的场合和时机？如何领略说话精髓，悟透说话之道，很快在众人中脱颖而出？\r\n\r\n说话不只是一种“感觉”，还是一门“技术”！就像烹饪有食谱一样，说话也有它的“秘方”。古往今来，但凡不通说话之道者，都难成大事，而能成事者，一定在语言方面具有其独特的能力。一句恰到好处的话，甚至可以改变一个人的命运。人际沟通中怎样措辞？怎样把握说话的场合和时机？如何领略说话精髓，悟透说话之道，很快在众人中脱颖而出？\r\n\r\n', '佐佐木圭一', '2021-11-26 21:23:35', '北京联合出版公司', NULL, '/img/bstore/b0028.jpg', 4, 32, 45, 0, '31e74931ab230bc9df18b55d68a238d4');
INSERT INTO `t_book` VALUES (27, '管理学', 58.10, '《管理学（第13版）》位列全球基础管理学教材的榜首，自引进我国以来，深受国内学界和业界的欢迎，也影响了无数的中国读者和管理者。全书以管理的四大职能——计划、组织、领导、控制为主体脉络，环环相扣，逻辑清晰，全面覆盖了管理理论的主要知识点，将管理理论与管理实践紧密结合，帮助读者提升管理技能。', '斯蒂芬·罗宾斯，玛丽·库尔特', '2021-11-04 21:31:28', '中国人民大学出版社', 75.00, '/img/bstore/b0029.jpg', 4, 25, 65, 0, '4a0d845db16aac51c91704f0d1bcdb15');
INSERT INTO `t_book` VALUES (28, '大卫科波菲尔', 50.00, '《大卫·科波菲尔 套装上下册/世界名著典藏》是英国小说家查尔斯·狄更斯的第八部长篇小说，主人公科波菲尔是个遗腹子，继父对他和母亲横加虐待。母亲不久去世，科波菲尔沦为孤儿，他找到了姨婆，在她的监护下开始新的生活。世事变迁，亲情友爱令人欢欣，风波和伤痛予人磨练，科波菲尔最终成为一名成功作家，并与至亲爱人幸福地结合。作品言语诙谐，爱憎分明，情节曲折，画卷宏大，体现了狄更斯一贯的风格。是狄更斯爱好者们的必读杰作。', '[英] 查尔斯·狄更斯', '2021-11-12 21:37:59', '中央编译出版社', NULL, '/img/bstore/b0030.jpg', 2, 21, 14, 0, 'e7017882294bc65df1d6e7b01edb4029');
INSERT INTO `t_book` VALUES (29, '双城记', 29.50, '那是好的年月，那是坏的年月。\r\n　　《狄更斯文集：双城记》是以法国大革命为背景写成的长篇历史小说，情节感人肺腑，是世界文学经典名著之一。小说将巴黎、伦敦这两个大城市联结起来，围绕着马内特医生一家和以德法日夫妇为首的圣安东尼区展开故事。\r\n　　《狄更斯文集：双城记》的主要思想是为了爱而牺牲自我。', '[英] 查尔斯·狄更斯', '2021-11-23 21:42:40', '人民文学出版社', 38.00, '/img/bstore/b0031.jpg', 2, 24, 25, 0, '1e0105305962b55ee7fe71e877c2a8e1');
INSERT INTO `t_book` VALUES (30, '月亮与六便士', 19.80, '“人世漫长得转瞬即逝，有人见尘埃，有人见星辰。你一生真正的抉择只有一次，你应该被梦想照亮，还是被金钱照亮？”', '[英] 查尔斯·狄更斯', '2021-11-04 21:48:59', '中国华侨出版社', 38.00, '/img/bstore/b0032.png', 2, 21, 15, 0, 'aa844c7111662f76b81f5e2fd9f6493f');
INSERT INTO `t_book` VALUES (31, '艺术概论', 41.60, '“艺术概论”是所有艺术课程中的一门主干课程和基础课程。本书是依照教育部2006年3月颁发的《全国普通高等学校公共艺术课程设置指导方案》的指导思想、课程目标和具体要求而编写的。', '黄柏青', '2021-11-26 21:56:45', '中国邮电出版社', 49.00, '/img/bstore/b0033.jpg', 3, 25, 15, 0, '59f45fd3b29afca319d65b8d681aeda1');
INSERT INTO `t_book` VALUES (32, '社会学百科', 84.00, '《DK社会学百科（全彩）》内容简介：社会的贫富差距能被消除吗？是什么诱导人们去犯罪？网络如何改变了人与人之间的关系？\r\n在历史长河中，人类始终都在探索如何治理社会这个重大问题，而社会学家们已经给出了一些方案，并持续塑造着今日的世界。 \r\n本书通俗易懂，精炼有力的解释破译了高深莫测的社会学术语，清晰流畅的图表剖析了深奥难懂的理论，机智诙谐的例证燃起我们\r\n关于社会及其制度的思想火花。 无论你是社会学的“热心份子”，还是深居书斋的“专家”，都会在《社会学百科》这本书中汲取\r\n到丰富的精神食粮。', '英国DK出版社', '2021-11-03 22:02:31', '电子工业出版社', 148.00, '/img/bstore/b0034.jpg', 5, 26, 16, 1, 'c9dfb3dade9d384172cd5399808e063b');
INSERT INTO `t_book` VALUES (33, '绿山墙的安妮', 35.40, '“中少•明天书系”是由中国少年儿童新闻出版总社与明天出版社联合打造的一套世界经典名著，囊括中小学课外阅读必读经典名著，如《伊索寓言》《绿山墙的安妮》《鲁滨孙漂流记》等，汇集著名翻译家叶君健、任溶溶、马爱农等品质超高、广受好评的经典译本，为小读者呈现出无删减、超精美的外国儿童文学大餐。\r\n\r\n', '[加] 露西·莫德·蒙哥玛利 ', '2021-12-01 22:06:34', '中国少年儿童出版社', 39.80, '/img/bstore/b0035.jpg', 6, 27, 25, 0, '9da0e7b89f5e847cc599dce759124454');
INSERT INTO `t_book` VALUES (34, '心若静，风奈何', 38.20, '《心若静，风奈何》是我国著名哲学家、美学家宗白华的作品集，作者将毕生精力投入哲学、美学及艺术理论的研究中，深得中国古典美学和西方现代美学精髓。在这些作品中，作者塑造了一种淡泊、宁静的生活方式，他以艺术家的心态去欣赏世间万物，并用行云流水般的文字将他的感受和认识呈现在读者面前。阅读这本书，读者除了能获得一种艺术享受之外，还能学会以平静的心态去面对人生。', '宗白华', '2021-12-03 22:09:51', '江西人民出版社', 42.00, '/img/bstore/b0036.jpg', 7, 29, 27, 0, '6bd4d23d4f60d7d9d59794fbeef2c1b4');
INSERT INTO `t_book` VALUES (35, 'The old man and the sea', 30.40, '《老人与海（全英文版）》讲述了一个发生在二十世纪中叶古巴的故事。主人公是一位圣地亚哥的老渔夫。这位风烛残年的渔夫一连八十四天都没有钓到一条鱼，几乎都快饿死了；但他仍然不肯认输，而充满着奋斗的精神，终于在第八十五天钓到一条大马林鱼。大鱼拖着船往大海走，但老人依然死拉着不放，即使没有水，没有食物，没有武器，没有帮手，而且左手又抽筋，他也丝毫不灰心。经过两天两夜之后，他终于杀死大鱼，把它拴在船边...', '[美] 海明威', '2021-12-05 22:16:25', '人民日报出版社', 32.80, '/img/bstore/b0037.jpg', 8, 27, 27, 1, 'fa2d0e316c579031d3c476109a53927e');
INSERT INTO `t_book` VALUES (36, '悲惨世界', 11.70, '《悲惨世界》是由法国作家在1862年发表的一部长篇，其内容涵盖了和之后的十几年的时间。\r\n\r\n故事的主线围绕主人公土伦苦刑犯（Jean Valjean）的个人经历，融进了法国的历史、革命、战争、、法律、正义、宗教信仰。该作多次被改编演绎成影视作品。', '[法] 雨果', '2021-12-06 22:20:51', '辽宁人民出版社', 26.00, '/img/bstore/b0038.jpg', 8, 27, 45, 0, 'db2060ce5b7eee2c1143cdf188114ff5');
INSERT INTO `t_book` VALUES (37, '20000 Leagues Under the Sea', 48.70, '《海底两万里》讲述了法国博物学家阿隆纳斯教授在鹦鹉螺号上历时近十个月、行程两万法里的海底探险。小说情节跌宕起伏，环环相扣。随着阿隆纳斯教授一行三人被鹦鹉螺号救起，一个个疑问相继产生：谁建造了鹦鹉螺号？海底探险的目的是什么？教授能否返回大陆？', '[法] 儒勒·凡尔纳 ', '2021-12-07 22:25:24', '江苏凤凰文艺出版社', 58.00, '/img/bstore/b0039.jpg', 8, 29, 28, 1, '064868f76efb602aa44f3ea02b828d9d');
INSERT INTO `t_book` VALUES (38, '星火英语四级考试', 42.80, NULL, '杨枫', '2021-12-08 22:32:45', '上海交通大学出版社', 65.80, '/img/bstore/b0040.jpg', 10, 21, 14, 0, '5b838fde2da5346c1d6f43f9cea6aa7a');
INSERT INTO `t_book` VALUES (39, '星火英语四级考试', 42.80, '备考2021年12月星火英语四级考试真题 新版大学英语4级通关历年真题试卷火星cet4全套复习资料词', '杨枫', '2021-12-08 22:32:45', '上海交通大学出版社', 65.80, '/img/bstore/b0040.jpg', 10, 17, 16, 0, '4b3ffa2fcbe689a308c55f2b9858611f');
INSERT INTO `t_book` VALUES (40, '自然哲学的数学原理', 58.00, '《自然哲学的数学原理》是牛顿的科学才华处于成熟时期所写的旷世巨著，是他“个人智慧的伟大结晶”。牛顿不但总结出了力学的基本定律，而且还发现了证明这些定律的数学方法，奠定了数学成为描述宇宙运动的语言的基础。在《自然哲学的数学原理》之后，人类在自然科学中的伟大成就层出不穷，但这些成就无一不与这部非凡的著作息息相关。牛顿提供了科学思维体系的样板。《自然哲学的数学原理》标志着经典力学体系的建立，是人类科学史乃至整个人类文明史中的不朽巨著。《自然哲学的数学原理》不仅影响着自它面世后的300年里的自然科学领域，而且对人类的宇宙观也产生了深刻的影响。', '[英] 艾萨克.牛顿', '2021-12-10 22:37:43', '重庆出版集团', NULL, '/img/bstore/b0041.jpg', 12, 14, 12, 1, 'efc8f87f423745efc9f8e70a54434c2c');
INSERT INTO `t_book` VALUES (41, '史记', 22.80, '《史记》，二十四史之一，最初称为《太史公书》或《太史公记》、《太史记》，是西汉史学家司马迁撰写的纪传体史书，是中国历史上第一部纪传体通史，记载了上至上古传说中的黄帝时代，下至汉武帝太初四年间共3000多年的历史。', '司马迁', '2021-11-30 22:44:33', '中国文联出版社', 42.00, '/img/bstore/b0042.jpg', 14, 14, 24, 1, 'bef8921c201910ed2c81f78159829df4');
INSERT INTO `t_book` VALUES (42, '孙子兵法', 22.80, '《孙子兵法（国学经典 全注全译）》又称《孙武兵法》，成书于春秋末期，在中国军事史上占有重要的地位，是中国古代军事文化遗产中的璀璨瑰宝，对中国历代军事家、政治家、思想家、经济学家都产生过非常深远的影响，享有“兵学圣典”的美誉。', '[春秋] 孙武', '2021-12-02 22:48:45', '中国文联出版社', 24.00, '/img/bstore/b0043.jpg', 14, 16, 58, 0, 'd9cd0bc929ae1787be9bedd2ad51193d');
INSERT INTO `t_book` VALUES (43, '北大哲学课 ', 28.20, '吉林文史出版社出版，博文编著。尽管这里什么信息都没有，但是通过ISBN确定的。通篇与北大毫无关系；硬要说与哲学有关的话，就是自问自答了一些人生的意义之类的话题吧。完全是中老年人微信朋友圈喜欢转发的垃圾哲思短语大集合。', '博文', '2021-11-09 22:52:21', '吉林文史出版社', 45.00, '/img/bstore/b0044.jpg', 15, 14, 24, 1, '83381ff62b780f2616a323dec3b83fa9');
INSERT INTO `t_book` VALUES (44, '中华人民共和国民法典', 29.20, '　民法典共7编84章，1200多条，包括总则编、物权编、合同编、人格权编、婚姻家庭编、继承编、侵权责任编，以及附则。', '中国法制出版社 ', '2021-11-26 23:00:01', '中国法制出版社', 65.00, '/img/bstore/b0045.jpg', 17, 24, 42, 0, 'deaae5ea710fb55dca90b6af4cd90ede');
INSERT INTO `t_book` VALUES (45, '资治通鉴', 576.00, '《资治通鉴》（常简作《通鉴》），是由北宋史学家司马光主编的一部多卷本编年体史书，共294卷，历时十九年完成。主要以时间为纲，事件为目，从周威烈王二十三年（公元前403年）写起，到五代后周世宗显德六年（公元959年）征淮南停笔，涵盖十六朝1362年的历史。', '[北宋] 司马光', '2021-11-01 23:04:12', '中州古籍出版社', 960.00, '/img/bstore/b0046.jpg', 19, 65, 54, 1, '95fee2690bcaf70a14a8cce142dc6575');
INSERT INTO `t_book` VALUES (46, '世界地理百科全', 45.80, '本书系统地介绍了世界上近百个国家和属地的地理特征、自然资源、经济、习俗、交通、旅游等诸多方面的知识，多角度解读世界自然和人文地理。', '侯海博', '2021-11-05 23:09:07', '北京联合出版公司', 112.00, '/img/bstore/b0047.jpg', 20, 24, 12, 1, 'fe6a605a4fff295d736a769803d7dcce');
INSERT INTO `t_book` VALUES (47, '黑旗 ISIS的崛起', 42.00, NULL, '[美] 乔比·沃里克', '2021-11-12 23:16:08', '中信出版集团', 56.00, '/img/bstore/b0047.jpg', 21, 45, 18, 1, '9a23594cfe2b54b452fe4d0385650aac');
INSERT INTO `t_book` VALUES (48, '黑旗 ISIS的崛起', 42.00, '《黑旗：ISIS的崛起》一书深入描述了ISIS奠基者扎卡维如何将一个从约旦黑狱中走出的组织，发展为足以操控全球60亿人心理恐慌的中东幽灵，同时首度揭露了小布什、奥巴马的接连军事误判，如何帮助恐怖组织ISIS一步步发展壮大。', '[美] 乔比·沃里克', '2021-11-12 23:16:08', '中信出版集团', 56.00, '/img/bstore/b0047.jpg', 21, 41, 4, 0, 'b56314b163861dc99b19ad50037b3db7');
INSERT INTO `t_book` VALUES (49, '情绪自救', 45.70, '良好的情绪是人生幸福的根基。你不能和自己的身心去斗争，这样只会把自己搞得更糟糕。你也不能对负面情绪视而不见，否则总有一天，它们会喷涌出来，反噬你的健康，甚至是你的社交和生活的方方面面，将你拉入痛苦的深渊。', '李宏夫', '2021-11-27 23:20:06', '中国人民大学出版社', 59.00, '/img/bstore/b0047.jpg', 23, 25, 3, 1, '14b02d712dc2671daaa8498b888c8874');

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car`  (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `u_id` int(20) NOT NULL,
  `product_id` int(20) NOT NULL,
  `product_num` int(10) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `f_user_car`(`u_id`) USING BTREE,
  INDEX `f_book_car`(`product_id`) USING BTREE,
  CONSTRAINT `f_user_car` FOREIGN KEY (`u_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `f_book_car` FOREIGN KEY (`product_id`) REFERENCES `t_book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_car
-- ----------------------------

-- ----------------------------
-- Table structure for t_compents
-- ----------------------------
DROP TABLE IF EXISTS `t_compents`;
CREATE TABLE `t_compents`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `user_id` int(20) NOT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_id` int(20) NOT NULL,
  `parent_comment_id` int(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `f_book_id`(`product_id`) USING BTREE,
  INDEX `f_praents_id`(`parent_comment_id`) USING BTREE,
  INDEX `f_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `f_book_id` FOREIGN KEY (`product_id`) REFERENCES `t_book` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `f_praents_id` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_compents` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `f_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_compents
-- ----------------------------
INSERT INTO `t_compents` VALUES (2, '2021-11-06 18:41:53', 2, 'oh my god ! this very intertesing', 2, NULL);
INSERT INTO `t_compents` VALUES (6, '2021-11-06 20:44:42', 5, 'nice, nice ,nice ', 2, 2);
INSERT INTO `t_compents` VALUES (7, '2021-11-06 20:47:54', 4, 'ok, ok, ok', 2, NULL);

-- ----------------------------
-- Table structure for t_orders
-- ----------------------------
DROP TABLE IF EXISTS `t_orders`;
CREATE TABLE `t_orders`  (
  `o_id` int(4) NOT NULL AUTO_INCREMENT,
  `c_id` int(4) NOT NULL,
  `o_time` datetime NOT NULL,
  `o_total` float NOT NULL,
  `o_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`o_id`) USING BTREE,
  INDEX `f_car_orders`(`c_id`) USING BTREE,
  CONSTRAINT `f_car_orders` FOREIGN KEY (`c_id`) REFERENCES `t_car` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_orders
-- ----------------------------

-- ----------------------------
-- Table structure for t_type
-- ----------------------------
DROP TABLE IF EXISTS `t_type`;
CREATE TABLE `t_type`  (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_type
-- ----------------------------
INSERT INTO `t_type` VALUES (1, '计算机');
INSERT INTO `t_type` VALUES (2, '外语');
INSERT INTO `t_type` VALUES (3, '艺术');
INSERT INTO `t_type` VALUES (4, '经管');
INSERT INTO `t_type` VALUES (5, '人文社科');
INSERT INTO `t_type` VALUES (6, '少儿');
INSERT INTO `t_type` VALUES (7, '生活');
INSERT INTO `t_type` VALUES (8, '进口原版');
INSERT INTO `t_type` VALUES (9, '科技');
INSERT INTO `t_type` VALUES (10, '考试');
INSERT INTO `t_type` VALUES (11, '励志');
INSERT INTO `t_type` VALUES (12, '学术');
INSERT INTO `t_type` VALUES (13, '小说');
INSERT INTO `t_type` VALUES (14, '古籍');
INSERT INTO `t_type` VALUES (15, '哲学');
INSERT INTO `t_type` VALUES (16, '旅游');
INSERT INTO `t_type` VALUES (17, '法律');
INSERT INTO `t_type` VALUES (18, '宗教');
INSERT INTO `t_type` VALUES (19, '历史');
INSERT INTO `t_type` VALUES (20, '地理');
INSERT INTO `t_type` VALUES (21, '政治');
INSERT INTO `t_type` VALUES (22, '军事');
INSERT INTO `t_type` VALUES (23, '心理学');
INSERT INTO `t_type` VALUES (24, '传记');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `passwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_money` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (2, '屌炸了', 'ae58c286b6b6ce5cba0910de1c8e5e4a', '430752298@qq.com', '19111910059', '我是胡洋', '/img/buser/elyse.png', 100.00);
INSERT INTO `t_user` VALUES (4, 'admin', 'dc7e4794774408a6ed0bafdce6ecbc29', '946115360@qq.com', '18283520430', 'i am backpackerxl', '/img/buser/avater.jpg', 1000.00);
INSERT INTO `t_user` VALUES (5, '龙在天', '542d6909f491a9e65c195994eaaa7808', 'yzhlsy2001@163.com', '18328971294', '我是飞龙在天', '/img/buser/elyse.png', 0.00);

SET FOREIGN_KEY_CHECKS = 1;
