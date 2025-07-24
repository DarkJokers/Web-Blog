<template>
  <div class="space-universe">
    <!-- 宇宙背景层 -->
    <div class="background-layer"></div>

    <!-- 页面内容 -->
    <div class="content relative z-10">
      <!-- 标题 -->
      <header class="text-center py-8">
        <h1 class="title">欢迎来到我的知识之门</h1>
        <p class="subtitle">每一扇门背后都藏着一段故事</p>
      </header>

      <!-- 门阵列 -->
      <section class="door-row">
        <div class="door-container" @click="openModule(door.key)" v-for="(door, index) in doors" :key="index">
          <div class="door-ring"></div>
          <div class="door-body">
            <span class="door-icon">{{ door.icon }}</span>
            <p class="door-label">{{ door.label }}</p>
          </div>
        </div>
      </section>

      <!-- 内容展示区 -->
      <section class="content-section">
        <ModuleContent v-if="activeModule" :module="activeModule" />
      </section>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import Door from '../components/Door.vue'
import ModuleContent from '../components/ModuleContent.vue'

const activeModule = ref('intro')

const doors = [
  { key: 'intro', label: '个人简介', icon: '🧍' },
  { key: 'skills', label: '技术栈', icon: '🔧' },
  { key: 'projects', label: '项目经历', icon: '🛠️' },
  { key: 'portfolio', label: '作品集', icon: '🖼️' },
  { key: 'hobbies', label: '兴趣爱好', icon: '🎮' },
  { key: 'research', label: '学术成果', icon: '📚' }
]

const openModule = (key) => {
  activeModule.value = key
}
</script>


<style>
.background-layer {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-image: url('/pexels-pixabay-2150.jpg');
  background-size: cover;
  background-position: center;
  z-index: -1;
  animation: zoomInOut 30s ease-in-out infinite;
  filter: brightness(0.6) contrast(1.2) saturate(1.2);
}

/* 每扇门的整体容器 */
.door-container {
  position: relative;
  width: 220px;
  height: 300px;
  perspective: 1000px;
  cursor: pointer;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
}

.door-container:hover {
  transform: scale(1.08) rotate(1deg);
  box-shadow: 0 0 30px rgba(0, 255, 255, 0.5);
}

/* 门本体 */
.door-body {
  position: absolute;
  width: 100%;
  height: 100%;
  background: linear-gradient(145deg, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0.05));
  border: 2px solid rgba(0, 255, 255, 0.3);
  border-radius: 20px;
  box-shadow: 0 0 20px rgba(0, 255, 255, 0.4), inset 0 0 20px rgba(0, 255, 255, 0.3);
  backdrop-filter: blur(4px);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  overflow: hidden;
  transition: all 0.3s ease;
  z-index: 1;
}

.door-body:hover {
  background-color: rgba(0, 255, 255, 0.1);
  box-shadow: 0 0 30px rgba(0, 255, 255, 0.6), inset 0 0 20px rgba(0, 255, 255, 0.4);
}

/* 门上的图标 */
.door-icon {
  font-size: 2.5rem;
  margin-bottom: 0.8rem;
  transition: transform 0.3s ease;
}

.door-body:hover .door-icon {
  transform: scale(1.3) rotate(15deg);
}

/* 门的文字描述 */
.door-label {
  font-size: 1.1rem;
  color: #ffffffdd;
  letter-spacing: 0.5px;
  transition: color 0.3s ease;
}

/* 光环特效 */
.door-ring {
  position: absolute;
  width: 120%;
  height: 120%;
  top: -10%;
  left: -10%;
  border: 2px dashed rgba(0, 255, 255, 0.3);
  border-radius: 50%;
  animation: spin 10s linear infinite, pulse 2s ease-in-out infinite;
  opacity: 0.5;
  pointer-events: none;
}

@keyframes spin {
  from {
    transform: rotate(0deg);
  }
  to {
    transform: rotate(360deg);
  }
}

@keyframes pulse {
  0% { box-shadow: 0 0 10px rgba(0, 255, 255, 0.4); }
  50% { box-shadow: 0 0 20px rgba(0, 255, 255, 0.8); }
  100% { box-shadow: 0 0 10px rgba(0, 255, 255, 0.4); }
}
</style>

<style scoped>
.space-universe {
  position: relative;
  min-height: 100vh;
  color: white;
  padding: 2rem;
}

.title {
  font-size: 2.5rem;
  font-weight: bold;
  background: linear-gradient(to right, #00ffe1, #7c6eff);
  -webkit-background-clip: text;
  color: transparent;
}

.subtitle {
  color: #aaa;
  margin-top: 0.5rem;
}

/* 门阵列 */
.door-row {
  display: flex;
  justify-content: center;
  gap: 2rem; /* 缩小间距 */
  flex-wrap: wrap;
  margin: 2rem 0;
  padding: 0 1rem;
}

.content-section {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
  border-top: 1px solid rgba(255, 255, 255, 0.1);
  background: rgba(255, 255, 255, 0.05);
  border-radius: 12px;
}
</style>
