<template>
  <div class="module-card">
    <h2 class="module-title">{{ title }}</h2>

    <!-- 内容容器 -->
    <div class="module-body">
      <!-- 个人简介 -->
      <div v-if="module === 'intro'" class="intro-section">
        <div class="intro-header">
          <img src="https://picsum.photos/id/1015/200/200 " alt="头像" class="avatar" />
          <h2 class="name">JayJelly</h2>
          <p class="bio">热爱科技与运动的开发者</p>
        </div>

        <div class="intro-grid">
          <div class="intro-item">
            <div class="label">📅 出生日期</div>
            <div class="value">2001年02月</div>
          </div>
          <div class="intro-item">
            <div class="label">🧍 性别</div>
            <div class="value">男</div>
          </div>
          <div class="intro-item">
            <div class="label">🧕 民族</div>
            <div class="value">汉族</div>
          </div>
          <div class="intro-item">
            <div class="label">🏠 籍贯</div>
            <div class="value">江西上饶</div>
          </div>
          <div class="intro-item">
            <div class="label">📍 现居地</div>
            <div class="value">杭州</div>
          </div>
          <div class="intro-item">
            <div class="label">🎓 本科学历</div>
            <div class="value">东北电力大学 · 智能科学与技术<br><small>2019.9 - 2023.6</small></div>
          </div>
          <div class="intro-item">
            <div class="label">📘 研究生学历</div>
            <div class="value">浙江工业大学 · 计算机技术<br><small>2023.9 - 2026.6</small></div>
          </div>
          <div class="intro-item">
            <div class="label">🧾 政治面貌</div>
            <div class="value">群众</div>
          </div>
          <div class="intro-item">
            <div class="label">🏢 工作意向</div>
            <div class="value">杭州 / 上海</div>
          </div>
          <div class="intro-item">
            <div class="label">📞 电话</div>
            <div class="value">185-7921-0685</div>
          </div>
          <div class="intro-item">
            <div class="label">📧 邮箱</div>
            <div class="value">1931858060@qq.com</div>
          </div>
          <div class="intro-item">
            <div class="label">📱 微信</div>
            <div class="value">Jax8_S</div>
          </div>
        </div>
      </div>

      <!-- 技术栈 -->
      <div v-else-if="module === 'skills'" class="skills-section">
        <h3 class="section-title">我掌握的技术</h3>

        <div class="skill-category">
          <h4 class="category-title">💻 编程语言</h4>
          <ul class="category-list">
            <li>熟练掌握 Java、Python、C++ 等编程语言</li>
            <li>具有良好的面向对象编程思想</li>
          </ul>
        </div>

        <div class="skill-category">
          <h4 class="category-title">🧱 设计模式与原则</h4>
          <ul class="category-list">
            <li>熟练掌握 Java 设计模式：策略、责任链、工厂等</li>
            <li>善用设计原则构建可复用、可维护的代码结构</li>
          </ul>
        </div>

        <div class="skill-category">
          <h4 class="category-title">⚙️ 后端开发框架</h4>
          <ul class="category-list">
            <li>熟悉 SpringBoot，具备使用 Spring、SpringMVC、MyBatis 进行整合开发的能力</li>
          </ul>
        </div>

        <div class="skill-category">
          <h4 class="category-title">💾 数据库与缓存</h4>
          <ul class="category-list">
            <li>熟练掌握 MySql，了解其主从同步、读写分离技术以及集群搭建</li>
            <li>深入理解 Redis 线程模型，掌握 Redis 的核心数据结构使用场景</li>
            <li>熟悉缓存高并发场景，如缓存雪崩、缓存穿透等</li>
          </ul>
        </div>

        <div class="skill-category">
          <h4 class="category-title">🧠 基础知识</h4>
          <ul class="category-list">
            <li>扎实的数据结构与算法基础</li>
            <li>深入理解操作系统、计算机组成原理、计算机网络</li>
          </ul>
        </div>
      </div>

      <!-- 项目经历 -->
      <div v-else-if="module === 'projects'" class="projects-section">
        <div class="project-card" v-for="(project, index) in projects" :key="index">
          <h3 class="project-title">{{ project.name }}</h3>
          <div class="project-meta">
            <span>📅 {{ project.time }}</span> |
            <span>🧑‍💼 {{ project.role }}</span>
          </div>
          <p class="project-desc">{{ project.description }}</p>
          <div class="project-links">
            <a :href="project.link" target="_blank" class="project-link">🔗 查看项目</a>
          </div>
        </div>
      </div>

      <!-- 作品集 -->
      <div v-else-if="module === 'portfolio'" class="portfolio-section">
        <div class="portfolio-grid">
          <img src="https://picsum.photos/id/1011/300/200 " alt="作品1" />
          <img src="https://picsum.photos/id/1012/300/200 " alt="作品2" />
          <img src="https://picsum.photos/id/1013/300/200 " alt="作品3" />
          <img src="https://picsum.photos/id/1014/300/200 " alt="作品4" />
        </div>
      </div>

      <!-- 兴趣爱好 -->
      <div v-else-if="module === 'hobbies'" class="hobbies-section">
        <div class="hobby-grid">
          <div class="hobby-card" v-for="(hobby, index) in hobbies" :key="index">
            <span class="hobby-icon">{{ hobby.icon }}</span>
            <h4 class="hobby-name">{{ hobby.name }}</h4>
            <p class="hobby-desc">{{ hobby.desc }}</p>
          </div>
        </div>
      </div>

      <!-- 学术成果 -->
      <div v-else-if="module === 'research'" class="research-section">
        <p>研究方向：人机交互、具身智能、多模态大模型</p>
        <ul class="list mt-3">
          <li>《一种基于多模态大模型的意图理解交互方法》</li>
          <li>《基于上下文生成和大小模型混合的多模态推理优化方法》</li>
        </ul>
      </div>
    </div>

    <!-- 光效线条 -->
    <div class="glow-line"></div>
  </div>
</template>

<script setup>
import { computed } from 'vue'

const props = defineProps({
  module: String
})

const titleMap = {
  intro: '🧑‍💻 个人简介',
  skills: '🔧 技术栈',
  projects: '🧪 项目经历',
  portfolio: '🖼 作品集',
  hobbies: '🎨 爱好',
  research: '📚 学术成果'
}

const title = computed(() => titleMap[props.module] || '未知模块')

// 项目数据
const projects = [
  {
    name: '拼团交易系统',
    time: '2025年2月 - 2024年6月',
    role: '后端开发',
    description: '开发对标美团/拼多多等大厂的交易场景，实现拼团组合下单、私域传播、组队结算等高并发核心功能，涵盖前后端开发及运维部署全流程，日均模拟订单量10W+。',
    link: 'https://github.com/DarkJokers/Technology-stack '
  },
  {
    name: '基于多模型协同架构的垂直领域智能对话系统',
    time: '2024年4月 - 2025年2月',
    role: '核心开发',
    description: '设计并实现了一个多模型协同的对话系统，根据不同业务意图开启专属流程，再通过任务路由（Task Routing）机制分配用户请求至专用模型（槽位抽取、通用模型、RAG、领域微调模型等），解决传统单一模型在专业领域回答模糊、多轮对话上下文丢失、通用能力羸弱问题。',
    link: 'https://github.com/DarkJokers/Study-Space '
  },
  {
    name: '智能服务机器人',
    time: '2024年4月 - 2025年2月',
    role: '核心开发',
    description: '通过多模态大模型出色能力，利用提示词工程让大模型进行任务规划，将用户指令分成细粒度任务，再根据任务的不同分配给不同模块，相较于传统能更准确理解用户需求，完成更复杂命令，为用户提供更智能更合理的服务。',
    link: 'https://github.com/DarkJokers/Research '
  },
  {
    name: '个人博客网站',
    time: '2025年7月 - 至今',
    role: '前端开发',
    description: '使用 Vue框架开发个人博客网站。',
    link: 'https://example.com/project4 '
  }
]

// 兴趣爱好数据（带影响描述）
const hobbies = [
  {
    name: '篮球',
    icon: '🏀',
    desc: '篮球是我释放压力的方式，让我能在压力和焦虑的情况下缓解情绪，也让我学会团队协作。'
  },
  {
    name: '音乐',
    icon: '🎵',
    desc: '音乐是我每天都会听的，尤其喜欢周杰伦、陶喆的歌曲，平时也会听说唱，它们都能让我沉浸其中，忘却烦恼。'
  },
  {
    name: '健身',
    icon: '💪',
    desc: '坚持健身让我保持充沛精力，也培养了自律精神，这种让我能在工作和学习更加集中精神。'
  },
  {
    name: '电影',
    icon: '🎬',
    desc: '电影是另一种人生体验，通过镜头语言感受不同文化与情感，拓宽了我的思维边界。'
  },
  {
    name: '综艺',
    icon: '📺',
    desc: '轻松有趣的综艺节目是我放松的方式，也是我观察世界的方式，喜欢看脱口秀、真人秀等类型综艺。'
  },
  {
    name: '阅读',
    icon: '📚',
    desc: '阅读让我不断吸收新知，尤其是技术书籍和文学类作品，帮助我建立系统性思维方式。'
  },
  {
    name: '游泳',
    icon: '🏊‍♂️',
    desc: '游泳是一项全身运动，在夏天我喜欢游泳，它能让我缓解焦虑，同时还能强身健体。'
  },
  {
    name: '摄影',
    icon: '📷',
    desc: '摄影教会我用不同的视角观察世界，捕捉瞬间之美，也提升了我的审美能力，同时希望有一天能将自己的生活记录下来。'
  },
  {
    name: '旅游',
    icon: '✈️',
    desc: '旅行让我走出舒适区，接触多元文化，喜欢自然景观，渴望在旷野中释放自我，每一次出发都是一次成长和自我发现。'
  }
]
</script>

<style scoped>
.module-card {
  background-color: rgba(255, 255, 255, 0.05);
  border: 1px solid rgba(0, 255, 225, 0.2);
  border-radius: 16px;
  box-shadow: 0 4px 20px rgba(0, 255, 225, 0.15);
  padding: 2rem;
  position: relative;
  backdrop-filter: blur(5px);
  animation: fadeInUp 0.6s ease forwards;
}

.module-title {
  font-size: 1.8rem;
  font-weight: bold;
  margin-bottom: 1.2rem;
  background: linear-gradient(to right, #00ffe1, #7c6eff);
  -webkit-background-clip: text;
  color: transparent;
  position: relative;
}

.module-title::after {
  content: '';
  position: absolute;
  bottom: -8px;
  left: 0;
  width: 60px;
  height: 2px;
  background: linear-gradient(to right, #00ffe1, #7c6eff);
  border-radius: 2px;
}

.module-body {
  font-size: 1rem;
  line-height: 1.6;
}

/* 个人简介部分 */
.intro-header {
  text-align: center;
}

.avatar {
  width: 100px;
  height: 100px;
  border-radius: 50%;
  margin: 0 auto 1rem auto;
  border: 2px solid #00ffff88;
  box-shadow: 0 0 15px rgba(0, 255, 255, 0.3);
  transition: transform 0.3s ease;
}

.avatar:hover {
  transform: rotate(360deg) scale(1.1);
  box-shadow: 0 0 20px rgba(0, 255, 255, 0.5);
}

.name {
  font-size: 1.5rem;
  font-weight: bold;
  background: linear-gradient(to right, #00ffe1, #7c6eff);
  -webkit-background-clip: text;
  color: transparent;
  margin-bottom: 0.5rem;
}

.bio {
  text-align: center;
  font-size: 1rem;
  color: #ccc;
  margin-bottom: 1.5rem;
}

.intro-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(180px, 1fr));
  gap: 1.2rem;
  margin-top: 1rem;
}

.intro-item {
  display: flex;
  flex-direction: column;
  padding: 1rem;
  background: rgba(255, 255, 255, 0.05);
  border-radius: 10px;
  border: 1px solid rgba(0, 255, 255, 0.1);
  transition: background 0.3s ease, transform 0.3s ease;
  white-space: pre-wrap;
  word-break: break-all;
}

.intro-item:hover {
  background: rgba(0, 255, 255, 0.08);
  transform: translateY(-2px);
}

.label {
  font-size: 0.9rem;
  color: #aaa;
  margin-bottom: 0.4rem;
}

.value {
  font-size: 1.1rem;
  font-weight: bold;
  color: #00ffff;
  white-space: pre-wrap;
  word-break: break-all;
}

/* 项目经历模块 */
.projects-section {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.project-card {
  background: rgba(255, 255, 255, 0.05);
  border: 1px solid rgba(0, 255, 255, 0.1);
  border-radius: 12px;
  padding: 1.5rem;
  transition: background 0.3s ease, transform 0.2s ease;
  position: relative;
}

.project-card:hover {
  background: rgba(0, 255, 255, 0.08);
  transform: translateY(-4px);
}

.project-title {
  font-size: 1.3rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
  background: linear-gradient(to right, #00ffe1, #7c6eff);
  -webkit-background-clip: text;
  color: transparent;
}

.project-meta {
  font-size: 0.9rem;
  color: #aaa;
  margin-bottom: 0.8rem;
}

.project-desc {
  font-size: 1rem;
  color: #ccc;
  line-height: 1.5;
  margin-bottom: 1rem;
}

/* 项目链接样式 */
.project-links {
  margin-top: 0.5rem;
}

.project-link {
  font-size: 0.9rem;
  color: #00ffff;
  text-decoration: none;
  padding: 0.4rem 0.8rem;
  border: 1px solid #00ffff;
  border-radius: 6px;
  transition: all 0.3s ease;
}

.project-link:hover {
  background-color: #00ffff;
  color: #000;
  box-shadow: 0 0 10px rgba(0, 255, 255, 0.4);
}

/* 技术栈模块样式 */
.skills-section {
  display: flex;
  flex-direction: column;
  gap: 1.5rem;
}

.section-title {
  font-size: 1.5rem;
  font-weight: bold;
  background: linear-gradient(to right, #00ffe1, #7c6eff);
  -webkit-background-clip: text;
  color: transparent;
  margin-bottom: 1rem;
}

.skill-category {
  background: rgba(255, 255, 255, 0.05);
  border-radius: 12px;
  padding: 1rem;
  border-left: 3px solid #00ffff;
  transition: background 0.3s ease, transform 0.2s ease;
}

.skill-category:hover {
  background: rgba(0, 255, 255, 0.08);
  transform: translateX(4px);
}

.category-title {
  font-size: 1.2rem;
  font-weight: bold;
  color: #00ffff;
  margin-bottom: 0.6rem;
}

.category-list {
  list-style-type: disc;
  padding-left: 1.5rem;
  color: #ddd;
}

.category-list li {
  margin-bottom: 0.4rem;
}

/* 作品集网格 */
.portfolio-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(120px, 1fr));
  gap: 0.8rem;
  margin-top: 1rem;
}

.portfolio-grid img {
  width: 100%;
  border-radius: 6px;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.portfolio-grid img:hover {
  transform: scale(1.05);
  box-shadow: 0 0 15px rgba(0, 255, 255, 0.4);
}

/* 兴趣爱好模块 */
.hobbies-section {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}

.hobby-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
  gap: 1.5rem;
  width: 100%;
  margin-top: 1rem;
}

.hobby-card {
  background: rgba(255, 255, 255, 0.05);
  border: 1px solid rgba(0, 255, 255, 0.1);
  border-radius: 12px;
  padding: 1.2rem;
  transition: all 0.3s ease;
  text-align: center;
}

.hobby-card:hover {
  background: rgba(0, 255, 255, 0.1);
  transform: translateY(-4px);
  box-shadow: 0 0 15px rgba(0, 255, 255, 0.2);
}

.hobby-icon {
  font-size: 2rem;
  display: block;
  margin-bottom: 0.5rem;
}

.hobby-name {
  font-size: 1.2rem;
  font-weight: bold;
  color: #00ffff;
  margin-bottom: 0.5rem;
}

.hobby-desc {
  font-size: 0.95rem;
  color: #ccc;
  line-height: 1.5;
}

/* 学术成果 */
.list {
  list-style-type: none;
  padding-left: 1.2rem;
}

.list li {
  position: relative;
  padding-left: 1rem;
  margin-bottom: 0.5rem;
}

.list li::before {
  content: '';
  position: absolute;
  left: 0;
  top: 0.3rem;
  width: 6px;
  height: 6px;
  background: cyan;
  border-radius: 50%;
}

/* 光效线条 */
.glow-line {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 4px;
  background: linear-gradient(to right, transparent, #00ffff, transparent);
  opacity: 0.3;
  animation: glowPulse 3s infinite;
}

@keyframes glowPulse {
  0%, 100% {
    opacity: 0.2;
  }
  50% {
    opacity: 0.6;
  }
}

@keyframes fadeInUp {
  from {
    opacity: 0;
    transform: translateY(30px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}
</style>
