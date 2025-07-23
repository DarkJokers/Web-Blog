<template>
  <div class="door-container" @click="$emit('click')">
    <div class="door-ring"></div>
    <div class="door-body">
      <span class="door-icon">{{ icon }}</span>
      <p class="door-label">{{ label }}</p>
    </div>
  </div>
</template>

<script setup>
defineProps({
  icon: String,
  label: String
})
</script>
