// 과제마다 setupXxx() 함수 하나로 나눈다.
// 각 함수는 자기 섹션의 요소만 다루고, 서로 의존하지 않는다.

/* =========================
   2-1. 버튼 클릭으로 텍스트와 인사 출력
   ========================= */
function setupGreeting() {
  const nameInput = document.querySelector('#name-input');
  const greetButton = document.querySelector('#greet-button');
  const output = document.querySelector('#greeting-output');

  function greet() {
    const name = nameInput.value.trim(); // 앞뒤 공백 제거

    // 출력 상태 클래스 초기화
    output.classList.remove('is-success', 'is-error');

    // 빈 입력(공백만 입력 포함) 처리
    if (name === '') {
      output.textContent = '이름을 입력해 주세요.';
      output.classList.add('is-error');
      nameInput.focus();
      return;
    }

    // textContent: 입력값을 글자 그대로 넣는다 (innerHTML과 달리 태그로 해석하지 않음)
    output.textContent = `Hello, ${name}`;
    output.classList.add('is-success');
  }

  // 버튼 클릭 이벤트 핸들러
  greetButton.addEventListener('click', greet);

  // 입력창에서 Enter를 눌러도 같은 동작
  nameInput.addEventListener('keydown', (event) => {
    // 한글 조합 중 Enter는 조합 완료용 → 무시 (중복 실행 방지)
    if (event.isComposing) {
      return;
    }
    if (event.key === 'Enter') {
      greet();
    }
  });
}

/* =========================
   실행
   ========================= */
setupGreeting();
