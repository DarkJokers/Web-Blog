<template>
  <div class="card" :class="{ expanded }" @click="$emit('click')">
    <h2>{{ title }}</h2>
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script setup>
defineProps({
  title: String,
  expanded: Boolean
})
</script>

<style scoped>
.card {
  background-color: rgba(255, 255, 255, 0.05);
  border: 1px solid rgba(0, 255, 225, 0.2);
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0, 255, 225, 0.1);
  padding: 1rem;
  cursor: pointer;
  transition: all 0.3s ease;
  overflow: hidden;
}

.card:hover {
  transform: scale(1.02);
}

.card h2 {
  font-size: 1.2rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
}

.content {
  max-height: 0;
  opacity: 0;
  transition: all 0.3s ease;
}

.card.expanded .content {
  max-height: 300px;
  opacity: 1;
  margin-top: 0.5rem;
}
</style>
