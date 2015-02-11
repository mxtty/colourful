$(document).ready(function() { 
	
	var subtotal = document.querySelector('.js-subtotal'),
    itemList = document.querySelector('.item-list'),
    priceFields = document.querySelectorAll('.item .js-item-price'),
    taxes = document.querySelector('.js-taxes'),
    shipping = document.querySelector('.js-shipping'),
    total = document.querySelector('.js-total'),
    summaryFields = document.querySelectorAll('.js-summary'),
    checkoutButton = document.querySelector('.js-checkout-button'),
    modalWrapper = document.querySelector('.js-modal-wrapper'),
    initialList = itemList.innerHTML


    
function loop (which, callback) {
  var len = which.length
      
  while (len--) {
    callback(which[len], len)
  }
}

function handleCalculations () {
  var subTotalPrice = 0,
      taxesPrice = 0,
      totalPrice = 0

  loop(priceFields, function (price) {
    subTotalPrice += +price.textContent.substr(1)
  })

  
  subtotal.textContent = '¥' + subTotalPrice.toFixed(2)
  
  total.textContent = '¥' + (subTotalPrice + (+shipping.textContent.substr(1))).toFixed(2)


}

function changeQuantity (emitter, action) {
  var action = emitter.classList.contains('js-item-increase') ? 'increase' : 'decrease',
      quantityField = emitter.parentElement.querySelector('span'),
      quantity = +quantityField.getAttribute('data-quantity'),
      price
  
  if (action === 'increase') {
    emitter.nextElementSibling.classList.remove('decrease--disabled')
  } else if (action === 'decrease') {
    if (quantity === 2) {
      emitter.classList.add('decrease--disabled')
    } else if (quantity === 1) {
      return
    }
  }
  
  quantityField.innerHTML = '<b>' + (action === 'increase' ? ++quantity : --quantity) + '</b> '
  quantityField.setAttribute('data-quantity', quantity)

  price = emitter.parentElement.parentElement.parentElement.querySelector('.js-item-price')

  price.textContent = '¥' + (quantity * price.getAttribute('data-price')).toFixed(2)
      
  handleCalculations()
}

function removeItem (emitter) {
  var item = emitter.parentElement.parentElement,
      len = priceFields.length,
      marginBottom = len > 1 ? parseInt(getComputedStyle(item).marginBottom, 10) : 0
      
  item.classList.add('item--disappearing')
  item.style.marginTop = -(item.offsetHeight + marginBottom) + 'px'
  
  setTimeout(function () {
    itemList.removeChild(item)
    
    priceFields = document.querySelectorAll('.item .js-item-price')
      
    if (!priceFields.length) {
      itemList.innerHTML = '<li class="item empty-hint"><p>结账的东西都没有啦 <a class="js-restore-list">再看看我的购物车</a>?</li>'
      itemList.firstElementChild.classList.add('is-visible')
      $(".js-summary").hide();
      
      //summaryFields = document.querySelectorAll('.js-summary')
      //summaryFields.hide()
      //alert(summaryFields.val())
      //summaryFields.addClass('is-not-visible')
      //summaryFields.style.marginTop = -(summaryFields.offsetHeight + 600) + 'px'
      //summaryFields.classList.add('item--disappearing')
     // alert(summaryFields.add('is-not-visible'))
    }

    
    handleCalculations()
  }, 500)
}

function restoreList () {
  itemList.firstElementChild.classList.remove('is-visible')
    
  setTimeout(function () {
    itemList.style.minHeight = itemList.offsetHeight + 'px'
    itemList.classList.add('appearing', 'delayed')
    itemList.innerHTML = initialList
    itemList.style.maxHeight = itemList.offsetHeight + 'px'
    itemList.classList.remove('appearing')
    priceFields = document.querySelectorAll('.item .js-item-price')
    handleCalculations()
    $(".js-summary").show();
  }, 500)
    
  setTimeout(function () {
    itemList.style.minHeight = 0
    itemList.style.maxHeight = 'none'
    itemList.classList.remove('delayed')
  }, 1500)
}

itemList.addEventListener('click', function (e) {
  var target = e.target,
      classList = target.classList
  
  if (classList.contains('js-item-increase') || classList.contains('js-item-decrease')) {
    changeQuantity(target)
  } else if (classList.contains('js-item-remove')) {
    removeItem(target)
  } else if (classList.contains('js-restore-list')) {
    restoreList()
  }
})

checkoutButton.addEventListener('click', function () {
  modalWrapper.classList.add('is-visible')
})

modalWrapper.addEventListener('click', function () {
  modalWrapper.classList.remove('is-visible')
})

setTimeout(function () {
  modalWrapper.style.display = 'block'
}, 250)
});