// js/database-operations.js

async function fetchGenderData() {
    try {
        showLoading();
        const response = await fetch('/genderData');
        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }
        const data = await response.json();
        hideLoading();
        return data;
    } catch (error) {
        hideLoading();
        showError('Failed to fetch data: ' + error.message);
        return [];
    }
}

function showLoading() {
    document.getElementById('loading').classList.remove('d-none');
}

function hideLoading() {
    document.getElementById('loading').classList.add('d-none');
}

function showError(message) {
    const errorElement = document.getElementById('error-message');
    errorElement.textContent = message;
    errorElement.classList.remove('d-none');
}

function hideError() {
    document.getElementById('error-message').classList.add('d-none');
}