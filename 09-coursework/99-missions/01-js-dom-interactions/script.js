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
   2-2. 모달 창 구현
   ========================= */
function setupModal() {
  const openButton = document.querySelector('#modal-open-button');
  const modal = document.querySelector('#modal');
  // 닫기 버튼이 2개(× 아이콘, 하단 버튼)라 data 속성으로 모두 찾는다
  const closeButtons = modal.querySelectorAll('[data-modal-close]');

  function openModal() {
    modal.classList.add('is-open');          // 모달 표시
    document.body.classList.add('has-modal'); // 뒤 페이지 스크롤 잠금
    closeButtons[0].focus();                  // 키보드 사용자를 위해 포커스를 모달 안으로
  }

  function closeModal() {
    modal.classList.remove('is-open');          // 모달 숨김
    document.body.classList.remove('has-modal');
    openButton.focus();                          // 포커스를 연 버튼으로 되돌림
  }

  openButton.addEventListener('click', openModal);

  closeButtons.forEach((button) => {
    button.addEventListener('click', closeModal);
  });

  // 바깥 배경(.modal 자체)을 클릭하면 닫기. 대화상자 안쪽 클릭은 무시
  modal.addEventListener('click', (event) => {
    if (event.target === modal) {
      closeModal();
    }
  });

  // Esc 키로 닫기 (열려 있을 때만)
  document.addEventListener('keydown', (event) => {
    if (event.key === 'Escape' && modal.classList.contains('is-open')) {
      closeModal();
    }
  });
}

/* =========================
   2-3. 구구단 출력기
   ========================= */
const MIN_DAN = 2;
const MAX_DAN = 9;

// 입력 문자열 검증 (조건문) → { ok: true, dan } 또는 { ok: false, message }
function validateDan(rawValue) {
  const text = rawValue.trim();

  if (text === '') {
    return { ok: false, message: '단을 입력해 주세요.' };
  }

  const dan = Number(text); // 입력값은 문자열 → 숫자로 변환

  if (!Number.isInteger(dan)) {
    return { ok: false, message: '정수를 입력해 주세요.' };
  } else if (dan < MIN_DAN || dan > MAX_DAN) {
    return { ok: false, message: `${MIN_DAN}~${MAX_DAN} 사이의 숫자를 입력해 주세요.` };
  }

  return { ok: true, dan };
}

// 구구단 계산 (반복문) → ['7 × 1 = 7', '7 × 2 = 14', ...]
function createTimesTable(dan) {
  const rows = [];
  for (let i = 1; i <= 9; i++) {
    rows.push(`${dan} × ${i} = ${dan * i}`);
  }
  return rows;
}

function setupTimesTable() {
  const danInput = document.querySelector('#dan-input');
  const timesButton = document.querySelector('#times-button');
  const output = document.querySelector('#times-output');

  function showError(message) {
    output.classList.add('is-error');
    output.textContent = message;
    danInput.focus();
  }

  function showTable(dan, rows) {
    output.classList.remove('is-error');

    const title = document.createElement('p');
    title.className = 'times-title';
    title.textContent = `${dan}단`;

    const list = document.createElement('ol');
    list.className = 'times-list';
    for (const row of rows) {
      const item = document.createElement('li');
      item.textContent = row;
      list.append(item);
    }

    // 이전 결과를 지우고 새 결과로 교체
    output.replaceChildren(title, list);
  }

  function printTimesTable() {
    const result = validateDan(danInput.value);

    if (!result.ok) {
      showError(result.message);
      return;
    }

    showTable(result.dan, createTimesTable(result.dan));
  }

  timesButton.addEventListener('click', printTimesTable);

  danInput.addEventListener('keydown', (event) => {
    if (event.isComposing) {
      return;
    }
    if (event.key === 'Enter') {
      printTimesTable();
    }
  });
}

/* =========================
   2-4. 이미지 효과 및 다크모드 토글
   ========================= */
function setupImageHover() {
  const image = document.querySelector('#hover-image');

  // 원래 이미지와 바뀔 이미지 (src, alt)
  const original = { src: image.getAttribute('src'), alt: image.alt };
  const hover = { src: image.dataset.hoverSrc, alt: image.dataset.hoverAlt };

  // 바뀔 이미지를 미리 불러 둔다 → 처음 마우스를 올릴 때 깜빡임 방지
  new Image().src = hover.src;

  function show({ src, alt }) {
    image.src = src;
    image.alt = alt; // 보이는 그림이 바뀌면 대체 텍스트도 맞춘다
  }

  // onmouseover / onmouseout과 같은 이벤트를 addEventListener로 등록
  image.addEventListener('mouseover', () => show(hover));
  image.addEventListener('mouseout', () => show(original));
}

function setupThemeToggle() {
  const toggleButton = document.querySelector('#theme-toggle');

  toggleButton.addEventListener('click', () => {
    // .dark가 없으면 붙이고, 있으면 뗀다. 반환값: 토글 후 .dark가 있는지
    const isDark = document.body.classList.toggle('dark');

    toggleButton.textContent = isDark ? '라이트모드로 전환' : '다크모드로 전환';
    toggleButton.setAttribute('aria-pressed', String(isDark));
  });
}

/* =========================
   실행
   ========================= */
setupGreeting();
setupModal();
setupTimesTable();
setupImageHover();
setupThemeToggle();
